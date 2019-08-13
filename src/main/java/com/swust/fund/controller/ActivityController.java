package com.swust.fund.controller;

import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.common.restful.UnicomRuntimeException;
import com.swust.fund.entity.Activity;
import com.swust.fund.entity.ActivityGroup;
import com.swust.fund.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ActivityController
 * @Package com.swust.fund.controller
 * @description: 活动控制器
 * @date 2019/7/5 16:34
 */
@Api(tags = "活动API")
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @ApiOperation("查找所有活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<Activity>> getAllActivity(int pageNum, int pageSize, @RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, activityService.getActivity(pageNum, pageSize, showAll));
    }

    @ApiOperation("查找单个活动")
    @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/activity/{activityId}", method = RequestMethod.GET)
    public ResponseJSON<Activity> getActivity(@PathVariable int activityId) {
        return new ResponseJSON<>(true, activityService.getActivity(activityId));
    }

    @ApiOperation("查找所有活动分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/activity-group", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<ActivityGroup>> getAllActivityGroup(int pageNum, int pageSize, @RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, activityService.getGroup(pageNum, pageSize, showAll));
    }


    @ApiOperation("查找单个活动分类")
    @ApiImplicitParam(name = "activityGroupId", value = "活动分类id", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/activity-group/{activityGroupId}", method = RequestMethod.GET)
    public ResponseJSON<ActivityGroup> getActivityGroup(@PathVariable int activityGroupId) {
        return new ResponseJSON<>(true, activityService.getGroup(activityGroupId));
    }

    @ApiOperation("添加新的活动")
    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseJSON<Integer> addActivity(Activity activity) {
        try {
            return new ResponseJSON<>(true, activityService.addActivity(activity));
        } catch (UnicomRuntimeException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST, "请检查输入参数是否正确");
        }
    }

    @ApiOperation("添加新的活动分类")
    @RequestMapping(value = "/activity-group", method = RequestMethod.POST)
    public ResponseJSON<Integer> addActivityGroup(ActivityGroup activityGroup) {
        try {
            return new ResponseJSON<>(true, activityService.addGroup(activityGroup));
        } catch (UnicomRuntimeException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.BAD_REQUEST, "请检查输入参数是否正确");
        }
    }

    @ApiOperation("修改活动信息")
    @RequestMapping(value = "/activity", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editActivity(Activity activity) {
        return new ResponseJSON<>(true, activityService.editActivity(activity));
    }

    @ApiOperation("修改分组信息")
    @RequestMapping(value = "/activity-group", method = RequestMethod.PUT)
    public ResponseJSON<Integer> editGroup(ActivityGroup activityGroup) {
        return new ResponseJSON<>(true, activityService.editGroup(activityGroup));
    }

    @ApiOperation("删除活动信息")
    @RequestMapping(value = "/activity/{activityId}", method = RequestMethod.DELETE)
    public ResponseJSON deleteActivity(@PathVariable int activityId) {
        if (activityService.deleteActivity(activityId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("删除活动分组信息")
    @RequestMapping(value = "/activity-group/{activityGroupId}", method = RequestMethod.DELETE)
    public ResponseJSON deleteGroup(@PathVariable int activityGroupId) {
        if (activityService.deleteGroup(activityGroupId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.NO_USER_EXIST);
        }
    }

    @ApiOperation("查找活动分组下的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityGroupId", value = "活动分类id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/activity/activity-group/{activityGroupId}", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<Activity>> getAllActivityByGroup(@PathVariable int activityGroupId, int pageNum, int pageSize, @RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, activityService.getActivity(activityGroupId, pageNum, pageSize, showAll));
    }

    @ApiOperation("加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户userId", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity/user", method = RequestMethod.POST)
    public ResponseJSON<Integer> signInActivity(int userId, int activityId) {
        try {
            return new ResponseJSON<>(true, activityService.signInActivity(userId, activityId), UnicomResponseEnums.SUCCESS_OPTION);

        } catch (UnicomRuntimeException e) {
            throw new UnicomRuntimeException(UnicomResponseEnums.REPEAT_REGISTER, "重复加入活动");
        }
    }

    @ApiOperation("退出活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户userId", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity/user", method = RequestMethod.DELETE)
    public ResponseJSON signOutActivity(int userId, int activityId) {
        if (activityService.signOutActivity(userId, activityId)) {
            return new ResponseJSON(true, UnicomResponseEnums.SUCCESS_OPTION);
        } else {
            return new ResponseJSON(false, UnicomResponseEnums.BAD_REQUEST);
        }
    }

    @ApiOperation("查找用户参加的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "showAll", value = "是否显示全部（用户不显示全部）", required = false, dataType = "boolean", paramType = "query")
    })
    @RequestMapping(value = "/activity/user/{userId}", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<Map>> getAllActivityByUser(@PathVariable int userId, int pageNum, int pageSize, @RequestParam(defaultValue = "false") boolean showAll) {
        return new ResponseJSON<>(true, activityService.getAllActivityByUser(userId, showAll, pageNum, pageSize));
    }
}
