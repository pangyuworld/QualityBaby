package com.swust.fund.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;
import java.util.Date;

@ApiModel("评论")
public class Message implements Serializable {
    @ApiModelProperty("评论id")
    private Integer messageId;

    @ApiModelProperty("评论时间")
    private Date messageTime;

    @ApiModelProperty("评论内容")
    private String messageDetail;

    @ApiModelProperty("评论点赞数(暂时不做)")
    private Integer messageLike;

    @ApiModelProperty("评论是否显示")
    private Boolean messageShow;

    @ApiModelProperty("用户id")
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