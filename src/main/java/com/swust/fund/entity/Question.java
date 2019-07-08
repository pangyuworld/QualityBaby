package com.swust.fund.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("问题")
public class Question {
    @ApiModelProperty("问题ID")
    private Integer questionId;

    @ApiModelProperty("问题描述")
    private String questionDetail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("问题添加的时间")
    private Date questionAddTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("问题上次更新的时间")
    private Date questionUpdateTime;

    @ApiModelProperty("问题顺序")
    private Integer questionSort;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail == null ? null : questionDetail.trim();
    }

    public Date getQuestionAddTime() {
        return questionAddTime;
    }

    public void setQuestionAddTime(Date questionAddTime) {
        this.questionAddTime = questionAddTime;
    }

    public Date getQuestionUpdateTime() {
        return questionUpdateTime;
    }

    public void setQuestionUpdateTime(Date questionUpdateTime) {
        this.questionUpdateTime = questionUpdateTime;
    }

    public Integer getQuestionSort() {
        return questionSort;
    }

    public void setQuestionSort(Integer questionSort) {
        this.questionSort = questionSort;
    }
}