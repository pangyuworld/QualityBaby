package com.swust.fund.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author pang
 * @version V1.0
 * @ClassName: CommonConst
 * @Package com.swust.question.common
 * @description: 常量集合
 * @date 2019/3/20 23:45
 */
@Component
@PropertySource("classpath:secret.properties")
public class CommonConst {
    /**
     * 微信接口基础url
     */
    public static String baseURL;
    /**
     * 文件上传根路径
     */
    public static String uploadPath;
    /**
     * 图片服务器路径
     */
    public static String imgServerPath;
    /**
     * 微信公众号所使用的token
     */
    public static String token;
    /**
     * 微信小程序的appid
     */
    public static String appletId;
    /**
     * 微信公众号所使用的的appid
     */
    public static String publicId;
    /**
     * 微信小程序的secret参数
     */
    public static String appletSecret;
    /**
     * 微信公众号的secret参数
     */
    public static String publicSecret;
    /**
     * SHA256加密的盐值
     */
    public static String salt;


    @Value("${img.server.path}")
    private String tempImgServerPath;

    @Value("${password.salt}")
    private String tempSalt;

    @Value("${weixin.base.url}")
    private String tempURL;

    @Value("${weixin.public.token}")
    private String tempToken;

    @Value("${weixin.public.appId}")
    private String tempPublicId;

    @Value("${weixin.applets.appId}")
    private String tempAppletId;

    @Value("${weixin.applets.secret}")
    private String tempAppletSecret;

    @Value("${weixin.public.secret}")
    private String tempPublicSecret;

    @Value("${file.upload.path}")
    private String tempUploadPath;

    @PostConstruct
    public void setUrl() {
        baseURL = this.tempURL;
    }

    @PostConstruct
    public void setAppletId() {
        appletId = this.tempAppletId;
    }

    @PostConstruct
    public void setAppletSecret() {
        appletSecret = this.tempAppletSecret;
    }

    @PostConstruct
    public void setPublicId() {
        publicId = this.tempPublicId;
    }

    @PostConstruct
    public void setPublicSecret() {
        publicSecret = this.tempPublicSecret;
    }

    @PostConstruct
    public void setToken() {
        token = this.tempToken;
    }

    @PostConstruct
    public void setSalt() {
        salt = this.tempSalt;
    }

    @PostConstruct
    public void setUploadPath() {
        uploadPath = this.tempUploadPath;
    }

    @PostConstruct
    public void setImgServerPath() {
        imgServerPath = this.tempImgServerPath;
    }
}
