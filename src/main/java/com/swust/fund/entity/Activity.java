package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("活动")
public class Activity implements Serializable {
    private static final long serialVersionUID = -13088960562222333L;
    @ApiModelProperty("活动id")
    private Integer activityId;

    @ApiModelProperty("活动名")
    private String activityName;

    @ApiModelProperty("活动介绍")
    private String activityInformation;

    @ApiModelProperty("活动宣传图片地址")
    private String activityImg;

    @ApiModelProperty("活动参与人数")
    private Integer activityPersonNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动开始时间")
    private Date activityStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动结束时间")
    private Date activityEnd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动开始报名时间（即添加时间）")
    private Date activityStartSignUp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动结束报名时间")
    private Date activityEndSignUp;

    @ApiModelProperty("活动是否显示")
    private Boolean activityShow;

    @ApiModelProperty("活动所属于的分组ID")
    private Integer groupId;

    @ApiModelProperty("分组所属于的分组信息")
    private ActivityGroup group;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityInformation() {
        return activityInformation;
    }

    public void setActivityInformation(String activityInformation) {
        this.activityInformation = activityInformation == null ? null : activityInformation.trim();
    }

    public String getActivityImg() {
        return activityImg;
    }

    public void setActivityImg(String activityImg) {
        this.activityImg = activityImg == null ? null : activityImg.trim();
    }

    public Integer getActivityPersonNum() {
        return activityPersonNum;
    }

    public void setActivityPersonNum(Integer activityPersonNum) {
        this.activityPersonNum = activityPersonNum;
    }

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public Date getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Date activityEnd) {
        this.activityEnd = activityEnd;
    }

    public Date getActivityStartSignUp() {
        return activityStartSignUp;
    }

    public void setActivityStartSignUp(Date activityStartSignUp) {
        this.activityStartSignUp = activityStartSignUp;
    }

    public Date getActivityEndSignUp() {
        return activityEndSignUp;
    }

    public void setActivityEndSignUp(Date activityEndSignUp) {
        this.activityEndSignUp = activityEndSignUp;
    }

    public Boolean getActivityShow() {
        return activityShow;
    }

    public void setActivityShow(Boolean activityShow) {
        this.activityShow = activityShow;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public ActivityGroup getGroup() {
        return group;
    }

    public Activity setGroup(ActivityGroup group) {
        this.group = group;
        return this;
    }
}