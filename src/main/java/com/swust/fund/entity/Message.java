package com.swust.fund.entity;

import java.util.Date;

public class Message {
    private Integer messageId;

    private Date messageTime;

    private String messageDetail;

    private Integer messageLike;

    private Boolean messageShow;

    private Integer userId;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail == null ? null : messageDetail.trim();
    }

    public Integer getMessageLike() {
        return messageLike;
    }

    public void setMessageLike(Integer messageLike) {
        this.messageLike = messageLike;
    }

    public Boolean getMessageShow() {
        return messageShow;
    }

    public void setMessageShow(Boolean messageShow) {
        this.messageShow = messageShow;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}