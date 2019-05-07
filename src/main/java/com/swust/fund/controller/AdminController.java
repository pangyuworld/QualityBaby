package com.swust.fund.controller;

import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AdminController
 * @Package com.swust.question.controller
 * @description: 管理员信息操作
 * @date 2019/4/6 17:00
 */
@Api(tags = "管理员信息操作")
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public ResponseJSON<String> login(String username, String password) {
        String result = adminService.login(username, password);
        if (result == null) {
            return new ResponseJSON<>(false, UnicomResponseEnums.NO_USER_EXIST);
        } else if (result.equals("-1")) {
            return new ResponseJSON<>(false, UnicomResponseEnums.NOT_MATCH);
        } else {
            return new ResponseJSON<>(true, result, UnicomResponseEnums.LOGIN_SUCCESS);
        }
    }

    @ApiOperation("管理员注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "realName", value = "真实用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "登录用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/admin/registered", method = RequestMethod.POST)
    public ResponseJSON registered(String realName, String username, String password) {
        adminService.registered(realName, username, password);
        return new ResponseJSON(true, "注册成功", UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("获得验证码")
    @RequestMapping(value = "/admin/capatcha", method = RequestMethod.GET)
    public String getVerificationCode() {
        return adminService.getKaptcha();
    }
}
