package com.swust.fund.entity;

public class Question {
    private Integer questionId;

    private String questionDetail;

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
}