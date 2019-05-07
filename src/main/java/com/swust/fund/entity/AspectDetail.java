package com.swust.fund.entity;

import java.io.Serializable;

public class AspectDetail implements Serializable {
    private Integer detailId;

    private String detailName;

    private Boolean detailShow;

    private Integer aspectId;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName == null ? null : detailName.trim();
    }

    public Boolean getDetailShow() {
        return detailShow;
    }

    public void setDetailShow(Boolean detailShow) {
        this.detailShow = detailShow;
    }

    public Integer getAspectId() {
        return aspectId;
    }

    public void setAspectId(Integer aspectId) {
        this.aspectId = aspectId;
    }
}