package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("填写的问卷")
public class Answer {
    @ApiModelProperty("答案ID")
    private Integer answerId;

    @ApiModelProperty("答案得分")
    private Byte answerRank;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("问题Id")
    private Integer questionId;

    @ApiModelProperty("回答的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date answerTime;



    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Byte getAnswerRank() {
        return answerRank;
    }

    public void setAnswerRank(Byte answerRank) {
        this.answerRank = answerRank;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }
}
