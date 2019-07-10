package com.swust.fund.dao;

import com.swust.fund.entity.Question;
import com.swust.fund.entity.QuestionAspect;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertQuestionAspect(@Param("questionId") Integer questionId,@Param("list") List<QuestionAspect> params);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> getAllQuestion();

    int deleteQuestionAspect(@Param("questionId") Integer questionId,@Param("detailId") Integer detailId);
}