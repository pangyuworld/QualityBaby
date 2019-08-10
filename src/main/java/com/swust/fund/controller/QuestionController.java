package com.swust.fund.controller;

import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.Answer;
import com.swust.fund.entity.Question;
import com.swust.fund.entity.QuestionAspect;
import com.swust.fund.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: QuestionController
 * @Package com.swust.fund.controller
 * @description: 问题API
 * @date 2019/7/9 10:23
 */
@Api(tags = "问题API")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiOperation("查找问题")
    @ApiImplicitParam(name = "questionId", value = "问题id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
    public ResponseJSON<Question> getQuestion(@PathVariable int questionId) {
        return new ResponseJSON<>(true, questionService.getQuestion(questionId));
    }

    @ApiOperation("查找问题")
    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseJSON<List<Question>> getAllQuestion() {
        return new ResponseJSON<>(true, questionService.getAllQuestion());
    }

    @ApiOperation("添加新的问题")
    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public ResponseJSON<Integer> addQuestion(Question question, @RequestBody List<QuestionAspect> questionAspect) {
        return new ResponseJSON<>(true, questionService.addQuestion(question, questionAspect));
    }

    @ApiOperation("删除问题")
    @ApiImplicitParam(name = "questionId", value = "问题id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.DELETE)
    public ResponseJSON deleteQuestion(@PathVariable int questionId) {
        if (questionService.deleteQuestoin(questionId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("删除问题和小方向的对应关系")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "问题id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "detailId", value = "问题对应的小方向id", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/question-detail", method = RequestMethod.DELETE)
    public ResponseJSON deleteQuestionAspect(int questionId, int detailId) {
        if (questionService.deleteQuestionAspect(questionId, detailId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("更新问题内容")
    @RequestMapping(value = "/question", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editQuestion(Question question) {
        return new ResponseJSON<>(true, questionService.editQuestion(question));
    }

    @ApiOperation("更新问题对应的小方向的影响")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "questionId", value = "问题id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "detailId", value = "问题对应的小方向id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "isWell", value = "修改后问题对应的方向", required = true, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/question-detail", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editQuestionAspect(int questionId, int detailId, boolean isWell) {
        return new ResponseJSON<>(true, questionService.editQuestoinAspect(questionId, detailId, isWell));
    }

    @ApiOperation("回答问题")
    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public ResponseJSON<Integer> answerQuestion(@RequestBody List<Answer> answerList) {
        return new ResponseJSON<>(true, questionService.addAnswer(answerList));
    }

    @ApiOperation("用户是否回答了问卷")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/answer/{userId}", method = RequestMethod.GET)
    public ResponseJSON<Boolean> isAnsweredByUserId(@PathVariable int userId) {
        return new ResponseJSON<>(true, questionService.isAnswered(userId));
    }
}
