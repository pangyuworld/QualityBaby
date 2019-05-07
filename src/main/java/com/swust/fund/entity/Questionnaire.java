package com.swust.fund.entity;

import java.io.Serializable;

public class Questionnaire implements Serializable {
    private Integer questionnaireId;

    private String questionnaireDetail;

    private Boolean questionnaireShow;

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireDetail() {
        return questionnaireDetail;
    }

    public void setQuestionnaireDetail(String questionnaireDetail) {
        this.questionnaireDetail = questionnaireDetail == null ? null : questionnaireDetail.trim();
    }

    public Boolean getQuestionnaireShow() {
        return questionnaireShow;
    }

    public void setQuestionnaireShow(Boolean questionnaireShow) {
        this.questionnaireShow = questionnaireShow;
    }
}