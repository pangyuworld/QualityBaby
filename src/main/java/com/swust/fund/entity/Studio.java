package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel("工作室")
public class Studio  implements Serializable {
    @ApiModelProperty("工作室ID")
    private Integer studioId;

    @ApiModelProperty("工作室名")
    private String studioName;

    @ApiModelProperty("工作室介绍")
    private String studioInformation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("工作室开始时间")
    private Date studioStart;

    @ApiModelProperty("工作室是否显示")
    private Boolean studioShow;

    private List<Activity> activityList;

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    public String getStudioInformation() {
        return studioInformation;
    }

    public void setStudioInformation(String studioInformation) {
        this.studioInformation = studioInformation == null ? null : studioInformation.trim();
    }

    public Date getStudioStart() {
        return studioStart;
    }

    public void setStudioStart(Date studioStart) {
        this.studioStart = studioStart;
    }

    public Boolean getStudioShow() {
        return studioShow;
    }

    public void setStudioShow(Boolean studioShow) {
        this.studioShow = studioShow;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public Studio setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
        return this;
    }
}