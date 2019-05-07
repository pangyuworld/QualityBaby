package com.swust.fund.entity;

import java.io.Serializable;

public class AdminUser implements Serializable {
    private Integer adminId;

    private String adminRealName;

    private String adminLoginName;

    private String adminLoginPassword;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminRealName() {
        return adminRealName;
    }

    public void setAdminRealName(String adminRealName) {
        this.adminRealName = adminRealName == null ? null : adminRealName.trim();
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName == null ? null : adminLoginName.trim();
    }

    public String getAdminLoginPassword() {
        return adminLoginPassword;
    }

    public void setAdminLoginPassword(String adminLoginPassword) {
        this.adminLoginPassword = adminLoginPassword == null ? null : adminLoginPassword.trim();
    }
}