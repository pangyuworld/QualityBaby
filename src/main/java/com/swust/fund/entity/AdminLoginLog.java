package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("管理员登录日志")
public class AdminLoginLog {
    @ApiModelProperty("记录ID")
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("登录时间")
    private Date loginTime;

    @ApiModelProperty("登录IP,Long型")
    private Long loginIp;

    @ApiModelProperty("登录IP,xxx.xxx.xxx.xxx型")
    private String loginIpDecode;

    @ApiModelProperty("登录管理员IP")
    private Integer adminId;


    @ApiModelProperty("登录管理员姓名，插入时候不用填写")
    private String adminName;

    public String getLoginIpDecode() {
        return loginIpDecode;
    }

    public void setLoginIpDecode(String loginIpDecode) {
        this.loginIpDecode = loginIpDecode;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Long getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Long loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}