package com.swust.fund.controller;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.entity.Activity;
import com.swust.fund.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: question
 * @description: 活动API
 * @author: pang
 * @create: 2019-05-07 10:49
 * @version: v1.0
 **/
@Api(tags = "活动API")
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @ApiOperation("查找单个活动")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseJSON<Activity> getById(@PathVariable int id) {
        return new ResponseJSON<>(true, activityService.getById(id));
    }

    @ApiOperation("分页查找活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseJSON<Page<Activity>> getAll(int pageNum, int pageSize) {
        return new ResponseJSON<>(true, activityService.getAll(pageNum, pageSize));
    }

    @ApiOperation("删除活动")
    @ApiImplicitParam(name = "id", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/activity/{id}", method = RequestMethod.DELETE)
    public ResponseJSON<Integer> deleteById(@PathVariable int id) {
        return new ResponseJSON<>(true, activityService.deleteById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("修改活动")
    @RequestMapping(value = "/activity", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editById(Activity activity) {
        return new ResponseJSON<>(true, activityService.edit(activity), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("添加活动")
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseJSON<Integer> add(Activity activity) {
        return new ResponseJSON<>(true, activityService.add(activity), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("根据工作室ID分页查找活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "工作室id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/studio/{id}/activity", method = RequestMethod.GET)
    public ResponseJSON<Page<Activity>> getAllByStudio(@PathVariable int id, int pageNum, int pageSize) {
        return new ResponseJSON<>(true, activityService.getAllByStudio(id, pageNum, pageSize));
    }

    @ApiOperation("分页查找工作室")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/user/activity/{userId}", method = RequestMethod.GET)
    public ResponseJSON<Page<Activity>> getByUserId(@PathVariable Integer userId, int pageNum, int pageSize) {
        return new ResponseJSON<>(true, activityService.getByUserId(userId, pageNum, pageSize));
    }

    @ApiOperation("加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动ID", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity/user/{activityId}", method = RequestMethod.POST)
    public ResponseJSON<Integer> signInStudio(@PathVariable Integer activityId, Integer userId) {
        try {
            return new ResponseJSON<>(true, activityService.signIn(activityId, userId), UnicomResponseEnums.SUCCESS_OPTION);
        } catch (RuntimeException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.REPEAT_REGISTER, "重复加入活动");
        }
    }

    @ApiOperation("退出活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动ID", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity/user/{activityId}", method = RequestMethod.DELETE)
    public ResponseJSON<Integer> signOutStudio(@PathVariable Integer activityId, Integer userId) {
        if (activityService.signOut(activityId, userId) == 1) {
            return new ResponseJSON<>(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON<>(false, UnicomResponseEnums.NO_RECORD);
        }
    }
}
