package com.swust.fund.controller;

import com.github.pagehelper.PageInfo;
import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.entity.AdminLoginLog;
import com.swust.fund.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseJSON<Map<String,String>> login(String username, String password, HttpServletRequest request) {
        String result = adminService.login(username, password, request);
        Map<String,String> map=new HashMap<>(2);
        if (result == null) {
            return new ResponseJSON<>(false, UnicomResponseEnums.NO_USER_EXIST);
        } else if (result.equals("-1")) {
            return new ResponseJSON<>(false, UnicomResponseEnums.NOT_MATCH);
        } else {
            map.put("token",result);
            map.put("adminName",adminService.findAdminUserByLoginName(username).getAdminRealName());
            return new ResponseJSON<>(true, map, UnicomResponseEnums.LOGIN_SUCCESS);
        }
    }

    @ApiOperation("管理员注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "realName", value = "真实用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "登录用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/admin/registered", method = RequestMethod.POST)
    public ResponseJSON<String> registered(String realName, String username, String password) {
        adminService.registered(realName, username, password);
        return new ResponseJSON<>(true, "注册成功", UnicomResponseEnums.SUCCESS_OPTION);
    }

    @ApiOperation("获得验证码")
    @RequestMapping(value = "/admin/capatcha", method = RequestMethod.GET)
    public String getVerificationCode() {
        return adminService.getKaptcha();
    }

    @ApiOperation("获取全部管理员日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "大小", required = true, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/admin/log", method = RequestMethod.GET)
    public ResponseJSON<PageInfo<AdminLoginLog>> getAdminLoginLog(int pageNum, int pageSize) {
        return new ResponseJSON<>(true, adminService.getAllLog(pageNum, pageSize));
    }
}
