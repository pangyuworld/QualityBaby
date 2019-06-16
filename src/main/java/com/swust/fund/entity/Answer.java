package com.swust.fund.entity;

public class Answer {
    private Integer answerId;

    private Byte answerRank;

    private Integer userId;

    private Integer questionId;

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
}