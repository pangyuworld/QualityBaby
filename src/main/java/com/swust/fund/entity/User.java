package com.swust.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("用户")
public class User implements Serializable {
    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户学号")
    private String stuId;

    @ApiModelProperty("用户电话号码")
    private String tellNum;

    @ApiModelProperty("用户班级姓名")
    private String className;

    @ApiModelProperty("用户性别")
    private Boolean gender;

    @ApiModelProperty("用户真实姓名")
    private String stuName;

    @ApiModelProperty("用户拥有的标签名")
    private String tagName;

    @ApiModelProperty("用户ID")
    private Integer tagId;

    @ApiModelProperty("用户ID")
    private Boolean tagShow;

    @ApiModelProperty("用户ID")
    private byte[] openId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStuId() {
        return stuId;
    }

    public User setStuId(String stuId) {
        this.stuId = stuId;
        return this;
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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public byte[] getOpenId() {
        return openId;
    }

    public void setOpenId(byte[] openId) {
        this.openId = openId;
    }

    public String getTagName() {
        return tagName;
    }

    public User setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public Integer getTagId() {
        return tagId;
    }

    public User setTagId(Integer tagId) {
        this.tagId = tagId;
        return this;
    }

    public Boolean getTagShow() {
        return tagShow;
    }

    public User setTagShow(Boolean tagShow) {
        this.tagShow = tagShow;
        return this;
    }
}