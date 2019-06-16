package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("活动")
public class Activity implements Serializable {
    /**
     * UID
     */
    private static final long serialVersionUID = -1308896056767610807L;

    @ApiModelProperty(value = "活动ID", hidden = true)
    private Integer activityId;

    @ApiModelProperty("活动名")
    private String activityName;

    @ApiModelProperty("活动介绍")
    private String activityInformation;

    @ApiModelProperty("最大人数")
    private Integer activityPersonNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动开始时间")
    private Date activityStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动结束时间")
    private Date activityEnd;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("活动开始报名时间")
    private Date activitySignUp;

    @ApiModelProperty("活动是否显示")
    private Boolean activityShow;

    @ApiModelProperty("活动所属的工作室ID")
    private Integer studioId;

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

    public Date getActivitySignUp() {
        return activitySignUp;
    }

    public void setActivitySignUp(Date activitySignUp) {
        this.activitySignUp = activitySignUp;
    }

    public Boolean getActivityShow() {
        return activityShow;
    }

    public void setActivityShow(Boolean activityShow) {
        this.activityShow = activityShow;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }
}