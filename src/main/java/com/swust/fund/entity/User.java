package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("用户")
public class User implements Serializable {
    private static final long serialVersionUID = -1308896056767610812L;
    @ApiModelProperty(value = "用户ID")
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

    @ApiModelProperty("微信openId")
    private byte[] openId;

    // @ApiModelProperty(value = "标签")
    // private List<Tag> tags;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "注册时间")
    private Date signUpTime;

    @ApiModelProperty("用户头像地址")
    private String userIcon;

    public Date getSignUpTime() {
        return signUpTime;
    }

    public User setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
        return this;
    }

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

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
    // public List<Tag> getTags() {
    //     return tags;
    // }
    //
    // public User setTags(List<Tag> tags) {
    //     this.tags = tags;
    //     return this;
    // }
}