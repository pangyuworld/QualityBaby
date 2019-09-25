package com.swust.fund.service;

import com.swust.fund.dao.AnswerMapper;
import com.swust.fund.dao.AspectDetailMapper;
import com.swust.fund.dao.QuestionMapper;
import com.swust.fund.entity.Answer;
import com.swust.fund.entity.Question;
import com.swust.fund.entity.QuestionAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private AspectDetailMapper detailMapper;
    @Autowired
    private AspectService aspectService;

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
        question.setQuestionAddTime(new Date());
        question.setQuestionUpdateTime(new Date());
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

    /**
     * 更新问题内容
     *
     * @param question
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/11
     */
    public Integer editQuestion(Question question) {
        question.setQuestionUpdateTime(new Date());
        return questionMapper.updateByPrimaryKeySelective(question);
    }

    /**
     * 修改问题对应的小方向
     *
     * @param questionId 问题id
     * @param detailId   小方向id
     * @param isWell     修改后的isWell
     * @return java.lang.Integer
     * @author pang
     * @date 2019/7/11
     */
    public Integer editQuestoinAspect(Integer questionId, Integer detailId, Boolean isWell) {
        return questionMapper.updateQuestionAspect(questionId, detailId, isWell);
    }

    /**
     * 处理用户回答问题的请求
     *
     * @param answerList 用户回答问题的列表
     * @return java.lang.Integer
     * @author pang
     * @date 2019/9/19
     */
    public Integer addAnswer(List<Answer> answerList) {
        sortAnswer(answerList);
        answerList.forEach(a -> a.setAnswerTime(new Date()));
        List<QuestionAspect> questionAspectList = questionMapper.selectAllQuestionAspect();
        Map<Integer, Integer> scoreMap = new HashMap<>(10);
        for (int i = 0, j = 0; i < answerList.size(); i++) {
            Answer ai = answerList.get(i);
            while (j < questionAspectList.size()) {
                QuestionAspect qj = questionAspectList.get(j);
                if (ai.getQuestionId() < qj.getQuestionId()) {
                    // TODO 如果i的id比j的id小，则i+1
                    break;
                } else if (ai.getQuestionId() > qj.getQuestionId()) {
                    // TODO 如果i的id比j的id大，则j+1
                    j++;
                    continue;
                } else {
                    // TODO 如果i和j的id相等
                    Integer score = scoreMap.get(qj.getAspectId()) == null ? 0 : scoreMap.get(qj.getAspectId());
                    if (qj.getWell()) {
                        // 正向
                        scoreMap.put(qj.getAspectId(), score + ai.getAnswerRank());
                    } else {
                        // 反向
                        scoreMap.put(qj.getAspectId(), score + (5 - ai.getAnswerRank()));
                    }
                    j++;
                }
            }
        }
        detailMapper.insertScore(answerList.get(0).getUserId(), scoreMap);
        // 更新成绩排名
        aspectService.updateSort();
        return answerMapper.insertAnswerList(answerList);
    }

    /**
     * 将回答按照问题id进行排序
     *
     * @param answerList 要排序的回答列表
     * @author pang
     * @date 2019/7/11
     */
    private void sortAnswer(List<Answer> answerList) {
        Collections.sort(answerList, new Comparator<Answer>() {
            @Override
            public int compare(Answer o1, Answer o2) {
                return o1.getQuestionId() - o2.getQuestionId();
            }
        });
    }

    /**
     * 判断用户是否回答了问题
     *
     * @param userId 要检查的用户ID
     * @return boolean
     * @author pang
     * @date 2019/8/10
     */
    public boolean isAnswered(Integer userId) {
        return (answerMapper.selectAllAnswerCount(userId) > 0);
    }
}
