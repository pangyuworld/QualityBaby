package com.swust.fund.interceptor;


import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.entity.AdminUser;
import com.swust.fund.service.AdminService;
import com.swust.fund.utils.redis.RedisUtil;
import com.swust.fund.utils.token.PassToken;
import com.swust.fund.utils.token.Token;
import com.swust.fund.utils.token.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TokenInterceptor
 * @Package com.swust.question.utils.token
 * @description: token拦截器的实现
 * @date 2019/4/7 9:08
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 进行简单的拦截器父类判断
        if (handler instanceof HandlerMethod) {
            // TODO 强制转型
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Token token = handlerMethod.getMethodAnnotation(Token.class);
            PassToken passToken = handlerMethod.getMethodAnnotation(PassToken.class);
            if (token == null) {
                // TODO 如果没有注解，则直接通过，不需要拦截器
                return true;
            }
            if (passToken != null) {
                // TODO 如果有跳过token验证的注解，则直接通过
                return true;
            }
            // TODO 获取token
            String tokenStr = request.getHeader("token");
            if (tokenStr == null || tokenStr.length() < 1) {
                // TODO 如果没有token，则抛出异常
                throw new UnicomRuntimeException(UnicomResponseEnums.NOLOGIN, "无token，请重新登录");
            }
            // TODO 解析token
            Claims claims = TokenUtil.parseJWT(tokenStr);
            String username;
            // TODO 获得用户名
            username = claims.getAudience();
            // TODO 查找管理员信息
            AdminUser adminUser = adminService.findAdminUserByLoginName(username);
            if (adminUser == null) {
                // TODO 用户不存在
                throw new UnicomRuntimeException(UnicomResponseEnums.NO_USER_EXIST, "用户不存在");
            }
            if (!redisUtil.get("token_"+username).toString().equals(tokenStr)){
                // TODO 如果token和redis中的不相同，则为失效的token（单点登录？）
                throw new UnicomRuntimeException(UnicomResponseEnums.LOGOUT_SUCCESS, "用户不存在");
            }
            // TODO token验证通过
            return true;
        }
        return false;
    }
}
