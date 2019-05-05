package com.swust.fund.entity;

import java.util.Date;

public class Activity {
    private Integer activityId;

    private String activityName;

    private String activityInformation;

    private Integer activityPersonNum;

    private Date activityStart;

    private Date activityEnd;

    private Date activitySignUp;

    private Boolean activityShow;

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