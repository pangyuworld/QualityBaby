package com.swust.fund.controller;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
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
    public ResponseJSON deleteById(@PathVariable int id) {
        return new ResponseJSON(true, activityService.deleteById(id), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("修改活动")
    @RequestMapping(value = "/activity", method = RequestMethod.PUT)
    public ResponseJSON editById(Activity activity) {
        return new ResponseJSON(true, activityService.edit(activity), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("添加活动")
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseJSON add(Activity activity) {
        return new ResponseJSON(true, activityService.add(activity), UnicomResponseEnums.SUCCESS_OPTION);
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
}
