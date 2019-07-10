package com.swust.fund.service;

import com.swust.fund.dao.QuestionMapper;
import com.swust.fund.entity.Question;
import com.swust.fund.entity.QuestionAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: QuestionService
 * @Package com.swust.fund.service
 * @description: 问题事务层
 * @date 2019/7/9 10:13
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 获得单个问题
     *
     * @param questionId 问题ID
     * @return com.swust.fund.entity.Question
     * @author pang
     * @date 2019/7/10
     */
    public Question getQuestion(int questionId) {
        return questionMapper.selectByPrimaryKey(questionId);
    }

    /**
     * 获得所有问题（不进行分页，直接查询所有，前台进行处理）
     *
     * @return java.util.List<com.swust.fund.entity.Question>
     * @author pang
     * @date 2019/7/10
     */
    public List<Question> getAllQuestion() {
        return questionMapper.getAllQuestion();
    }

    /**
     * 添加新的问题
     *
     * @param question       新的问题
     * @param questionAspect 问题对应方面的参数
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    public Integer addQuestion(Question question, List<QuestionAspect> questionAspect) {
        questionMapper.insert(question);
        return addQuestionAspect(question.getQuestionId(), questionAspect);
    }

    /**
     * 为问题添加对应方面
     *
     * @param questionId     问题id
     * @param questionAspect 对应方面的参数
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/10
     */
    private Integer addQuestionAspect(Integer questionId, List<QuestionAspect> questionAspect) {
        return questionMapper.insertQuestionAspect(questionId, questionAspect);
    }

    /**
     * 删除问题
     *
     * @param questionId 问题ID
     * @return java.lang.Boolean 删除成功返回true
     * @author pang
     * @date 2019/7/10
     */
    public Boolean deleteQuestoin(Integer questionId) {
        if (questionMapper.deleteByPrimaryKey(questionId) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除问题影响关系
     *
     * @param questionId 问题ID
     * @param detailId   小方向ID
     * @return java.lang.Boolean
     * @author pang
     * @date 2019/7/10
     */
    public Boolean deleteQuestionAspect(Integer questionId, Integer detailId) {
        if (questionMapper.deleteQuestionAspect(questionId, detailId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
