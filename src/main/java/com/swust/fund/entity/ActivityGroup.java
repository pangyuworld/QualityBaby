package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("活动分组")
public class ActivityGroup {
    @ApiModelProperty("分组id")
    private Integer groupId;

    @ApiModelProperty("分组名")
    private String gourpName;

    @ApiModelProperty("分组是否显示")
    private Boolean groupShow;

    @ApiModelProperty("分组显示在小程序上的图标地址")
    private String groupIcon;

    @ApiModelProperty("分组顺序")
    private Byte groupSort;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("分组添加时间")
    private Date groupAddTime;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGourpName() {
        return gourpName;
    }

    public void setGourpName(String gourpName) {
        this.gourpName = gourpName == null ? null : gourpName.trim();
    }

    public Boolean getGroupShow() {
        return groupShow;
    }

    public void setGroupShow(Boolean groupShow) {
        this.groupShow = groupShow;
    }

    public String getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon == null ? null : groupIcon.trim();
    }

    public Byte getGroupSort() {
        return groupSort;
    }

    public void setGroupSort(Byte groupSort) {
        this.groupSort = groupSort;
    }

    public Date getGroupAddTime() {
        return groupAddTime;
    }

    public void setGroupAddTime(Date groupAddTime) {
        this.groupAddTime = groupAddTime;
    }
}