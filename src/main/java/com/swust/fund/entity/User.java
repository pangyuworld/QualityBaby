package com.swust.fund.entity;

public class User {
    private Integer userId;

    private Integer stuId;

    private String tellNum;

    private String className;

    private Boolean gender;

    private byte[] openId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getTellNum() {
        return tellNum;
    }

    public void setTellNum(String tellNum) {
        this.tellNum = tellNum == null ? null : tellNum.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public byte[] getOpenId() {
        return openId;
    }

    public void setOpenId(byte[] openId) {
        this.openId = openId;
    }
}