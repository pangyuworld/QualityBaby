package com.swust.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("标签")
public class Tag implements Serializable {
    private static final long serialVersionUID = -1308896056765512312L;

    @ApiModelProperty("标签ID")
    private Integer tagId;

    @ApiModelProperty("标签名")
    private String tagName;

    @ApiModelProperty("是否显示")
    private Boolean tagShow;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Boolean getTagShow() {
        return tagShow;
    }

    public void setTagShow(Boolean tagShow) {
        this.tagShow = tagShow;
    }
}