package com.swust.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("大方向")
public class Aspect implements Serializable {
    private static final long serialVersionUID = -130811215251252L;
    @ApiModelProperty("大方向ID")
    private Integer aspectId;

    @ApiModelProperty("大方向名字")
    private String aspectName;

    @ApiModelProperty("是否显示")
    private Boolean aspectShow;

    public Integer getAspectId() {
        return aspectId;
    }

    public void setAspectId(Integer aspectId) {
        this.aspectId = aspectId;
    }

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName == null ? null : aspectName.trim();
    }

    public Boolean getAspectShow() {
        return aspectShow;
    }

    public void setAspectShow(Boolean aspectShow) {
        this.aspectShow = aspectShow;
    }
}