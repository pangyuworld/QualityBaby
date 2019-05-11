package com.swust.fund.controller;

import com.swust.fund.common.Page;
import com.swust.fund.common.restful.ResponseJSON;
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

}
