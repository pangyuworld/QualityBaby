package com.swust.fund.entity;

import java.io.Serializable;

public class Option implements Serializable {
    private Integer optionId;

    private String optionDetail;

    private Boolean optionShow;

    private Byte optionOrder;

    private Integer questionId;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionDetail() {
        return optionDetail;
    }

    public void setOptionDetail(String optionDetail) {
        this.optionDetail = optionDetail == null ? null : optionDetail.trim();
    }

    public Boolean getOptionShow() {
        return optionShow;
    }

    public void setOptionShow(Boolean optionShow) {
        this.optionShow = optionShow;
    }

    public Byte getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(Byte optionOrder) {
        this.optionOrder = optionOrder;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}