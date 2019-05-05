package com.swust.fund.entity;

public class Question {
    private Integer questionId;

    private String questionDetail;

    private Boolean questionShow;

    private Integer questionnaireId;

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

    public Boolean getQuestionShow() {
        return questionShow;
    }

    public void setQuestionShow(Boolean questionShow) {
        this.questionShow = questionShow;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}