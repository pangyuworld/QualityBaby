package com.swust.fund.interceptor;

import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.utils.token.PassToken;
import com.swust.fund.utils.token.Token;
import com.swust.fund.utils.wx.WxRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pang
 * @version V1.0
 * @ClassName: WxRequestInterceptor
 * @Package com.swust.fund.interceptor
 * @description: 微信小程序接口拦截器
 * @date 2019/9/13 11:55
 */
@Component
public class WxRequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            // TODO 强制转型
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            WxRequest wxRequest = handlerMethod.getMethodAnnotation(WxRequest.class);
            if (wxRequest == null) {
                // TODO 如果没有注解，则直接通过，不需要拦截器
                return true;
            }
            String userAgent=request.getHeader("User-Agent");
            if (userAgent.contains("MicroMessenger")){
                // 如果是微信发出来的请求，则通过
                return super.preHandle(request, response, handler);
            }else {
                // 否则抛出异常
                throw new UnicomRuntimeException(UnicomResponseEnums.METHOD_NOT_ALLOWED,"请求失败");
            }
        }
        return false;
    }
}



