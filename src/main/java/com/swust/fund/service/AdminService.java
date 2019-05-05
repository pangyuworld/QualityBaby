package com.swust.fund.service;

import com.google.code.kaptcha.Producer;
import com.swust.fund.common.CommonConst;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.AdminUserMapper;
import com.swust.fund.entity.AdminUser;
import com.swust.fund.utils.kaptcha.KaptchaUtil;
import com.swust.fund.utils.password.PasswordUtil;
import com.swust.fund.utils.redis.RedisUtil;
import com.swust.fund.utils.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdminService
 * @Package com.swust.fund.service
 * @description: 管理员事务层
 * @date 2019/5/4 16:47
 */
@Service
public class AdminService {
    @Autowired
    private AdminUserMapper adminUserMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private Producer producer;
    @Autowired
    private KaptchaUtil kaptchaUtil;

    /**
     * 管理员登录逻辑
     *
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     * @author pang
     * @date 2019/4/7
     */
    public String login(String username, String password) {
        AdminUser adminUser = adminUserMapper.findByAdminLoginName(username);
        if (adminUser == null) {
            return null;
        }
        if (!adminUser.getAdminLoginPassword().equals(PasswordUtil.SHA256(password+CommonConst.salt))) {
            return "-1";
        }
        String token = TokenUtil.createJWT(1000 * 60 * 60, username, "administrator");
        redisUtil.set("token_" + username, token, 1000 * 60 * 60);
        return token;
    }

    /**
     * 管理员注册
     *
     * @param realName 真实姓名
     * @param username 登录名
     * @param password 登录密码
     * @return void
     * @author pang
     * @date 2019/5/4
     */
    public void registered(String realName, String username, String password) {
        password = PasswordUtil.SHA256(password + CommonConst.salt);
        AdminUser adminUser = new AdminUser();
        adminUser.setAdminLoginName(username);
        adminUser.setAdminLoginPassword(password);
        adminUser.setAdminRealName(realName);
        try {
            adminUserMapper.insert(adminUser);
        } catch (UnicomRuntimeException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.REPEAT_REGISTER);
        }
    }

    /**
     * 根据用户名查找管理员信息，用于token拦截器
     *
     * @param username
     * @return com.swust.question.entity.AdminUser
     * @author pang
     * @date 2019/4/7
     */
    public AdminUser findAdminUserByLoginName(String username) {
        return adminUserMapper.findByAdminLoginName(username);
    }

    /**
     * 获得验证码的base64编码
     *
     * @param
     * @return java.lang.String
     * @author pang
     * @date 2019/4/12
     */
    public String getKaptcha() {
        // 生成验证码内容
        String capText = producer.createText();
        // 获得base64编码
        String encode = null;
        try {
            encode = kaptchaUtil.getKaptcha(capText);
        } catch (IOException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.SYSTEM_ERROR, "验证码获取失败");
        }
        return encode;
    }
}
