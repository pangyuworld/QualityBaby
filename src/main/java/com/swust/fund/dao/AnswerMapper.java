package com.swust.fund.dao;

import com.swust.fund.entity.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    int insertAnswerList(List<Answer> answerList);

    int selectAllAnswerCount(@Param("userId")Integer userId);
}