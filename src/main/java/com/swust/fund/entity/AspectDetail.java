package com.swust.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("小方向")
public class AspectDetail implements Serializable {

    private static final long serialVersionUID = -1308896056123123812L;
    @ApiModelProperty("小方向ID")
    private Integer detailId;

    @ApiModelProperty("小方向名字")
    private String detailName;

    @ApiModelProperty("小方向是否显示")
    private Boolean detailShow;

    @ApiModelProperty("小方向所属的大方向ID")
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