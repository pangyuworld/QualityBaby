package com.swust.fund.entity;

import java.io.Serializable;

public class Tag  implements Serializable {
    private Integer tagId;

    private String tagName;

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