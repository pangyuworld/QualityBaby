package com.swust.fund.entity;

import java.io.Serializable;

public class Aspect implements Serializable {
    private Integer aspectId;

    private String aspectName;

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