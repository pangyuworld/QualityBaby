package com.swust.fund.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Producer;
import com.swust.fund.common.CommonConst;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.dao.AdminLoginLogMapper;
import com.swust.fund.dao.AdminUserMapper;
import com.swust.fund.entity.AdminLoginLog;
import com.swust.fund.entity.AdminUser;
import com.swust.fund.utils.ip.IpUtil;
import com.swust.fund.utils.kaptcha.KaptchaUtil;
import com.swust.fund.utils.password.PasswordUtil;
import com.swust.fund.utils.redis.RedisUtil;
import com.swust.fund.utils.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

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
    @Autowired
    private AdminLoginLogMapper logMapper;

    /**
     * 管理员登录逻辑
     *
     * @param username 用户名
     * @param password 密码
     * @return java.lang.String
     * @author pang
     * @date 2019/4/7
     */
    public String login(String username, String password,String key,String captcha, HttpServletRequest request) {
        // 验证验证码是否有效
        if (redisUtil.get(key)==null||redisUtil.get(key).toString().compareTo(captcha)!=0){
            // 如果验证码无效，则返回-2
            return "-2";
        }
        // 清除redis数据
        redisUtil.del(key);
        // 从数据库查到登录的管理员信息
        AdminUser adminUser = adminUserMapper.findByAdminLoginName(username);
        // 如果没有找到，则返回空
        if (adminUser == null) {
            return null;
        }
        // 如果登录的密码和数据库解密后的密码不一样，则返回-1
        if (!adminUser.getAdminLoginPassword().equals(PasswordUtil.SHA256(password + CommonConst.salt))) {
            return "-1";
        }
        String token = TokenUtil.createJWT(1000 * 60 * 60, username, "administrator");
        // 构建新的用户登录日志
        AdminLoginLog loginLog = new AdminLoginLog();
        // 获得用户IP
        Long ipAddress = IpUtil.getIpConvertNum(IpUtil.getIpAddr(request));
        // 设置登录用户ID
        loginLog.setAdminId(adminUser.getAdminId());
        // 设置登录IP
        loginLog.setLoginIp(ipAddress);
        // 设置登录时间
        loginLog.setLoginTime(new Date());
        // 添加登录记录
        logMapper.insert(loginLog);
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
    public String getKaptcha(String key) {
        // 生成验证码内容
        String capText = producer.createText();
        // 先清除之前的验证码
        redisUtil.del(key);
        // 将验证码内容存入缓存，并设置2分钟失效
        redisUtil.set(key,capText,1000*60*2);
        // 获得base64编码
        String encode = null;
        try {
            encode = kaptchaUtil.getKaptcha(capText);
        } catch (IOException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.SYSTEM_ERROR, "验证码获取失败");
        }
        return encode;
    }

    /**
     * 获得全部管理员日志
     *
     * @param pageNum  页码
     * @param pageSize 大小
     * @return com.github.pagehelper.PageInfo<com.swust.fund.entity.AdminLoginLog>
     * @author pang
     * @date 2019/7/9
     */
    public PageInfo<AdminLoginLog> getAllLog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<AdminLoginLog> logPage = logMapper.selectAllLog();
        for (AdminLoginLog a : logPage) {
            a.setLoginIpDecode(IpUtil.getNumConvertIp(a.getLoginIp()));
        }
        return new PageInfo<>(logPage);
    }
}
