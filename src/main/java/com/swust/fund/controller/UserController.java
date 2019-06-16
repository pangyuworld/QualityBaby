package com.swust.fund.controller;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.User;
import com.swust.fund.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserController
 * @Package com.swust.fund.controller
 * @description: 用户API
 * @date 2019/5/11 12:40
 */
@Api(tags = "用户API")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("根据openId查找用户")
    @ApiImplicitParam(name = "openId", value = "用户openId", required = true, dataType = "string", paramType = "query")
    @RequestMapping(value = "/user/openId", method = RequestMethod.POST)
    public ResponseJSON<User> getUserByOpenId(String openId) {
        return new ResponseJSON<>(true, userService.getUserByOpenId(openId));
    }

    @ApiOperation("根据userId查找用户")
    @ApiImplicitParam(name = "userId", value = "用户userId", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseJSON<User> getUserByUserId(@PathVariable int userId) {
        return new ResponseJSON<>(true, userService.getUserById(userId));
    }

    @ApiOperation("分页查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseJSON<Page<User>> getAll(int pageNum, int pageSize) {
        return new ResponseJSON<>(true, userService.getAllUser(pageNum, pageSize));
    }

    @ApiOperation("更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openId", value = "微信openId", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "stuId", value = "用户学号", required = true, dataType = "string", paramType = "query", example = "5120170586"),
            @ApiImplicitParam(name = "tellNum", value = "用户电话号码", required = false, dataType = "string", paramType = "query", example = "15681910683"),
            @ApiImplicitParam(name = "className", value = "用户班级姓名", required = false, dataType = "string", paramType = "query", example = "物联1704"),
            @ApiImplicitParam(name = "gender", value = "用户性别", required = false, dataType = "boolean", paramType = "query", example = "true"),
            @ApiImplicitParam(name = "stuName", value = "用户姓名", required = false, dataType = "string", paramType = "query", example = "张星宇"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseJSON<User> edit(User user) {
        userService.editUser(user);
        return new ResponseJSON<>(true, user, UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("添加新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openId", value = "微信openId", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "stuId", value = "用户学号", required = true, dataType = "string", paramType = "query", example = "5120170586"),
            @ApiImplicitParam(name = "tellNum", value = "用户电话号码", required = true, dataType = "string", paramType = "query", example = "15681910683"),
            @ApiImplicitParam(name = "className", value = "用户班级姓名", required = true, dataType = "string", paramType = "query", example = "物联1704"),
            @ApiImplicitParam(name = "gender", value = "用户性别", required = true, dataType = "boolean", paramType = "query", example = "true"),
            @ApiImplicitParam(name = "stuName", value = "用户姓名", required = true, dataType = "string", paramType = "query", example = "张星宇"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseJSON<Integer> add(User user) {
        return new ResponseJSON<>(true, userService.addUser(user), UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("获得参加活动的用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/activity/user/{activityId}", method = RequestMethod.GET)
    public ResponseJSON<Page<Map>> getByActivityId(@PathVariable Integer activityId, Integer pageNum, Integer pageSize) {
        return new ResponseJSON<>(true, userService.getByActivityId(activityId, pageNum, pageSize));
    }

    @ApiOperation("获得参加工作室的用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studioId", value = "工作室id", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/studio/user/{studioId}", method = RequestMethod.GET)
    public ResponseJSON<Page<Map>> getByStudioId(@PathVariable Integer studioId, Integer pageNum, Integer pageSize) {
        return new ResponseJSON<>(true, userService.getByStudioId(studioId, pageNum, pageSize));
    }
}
