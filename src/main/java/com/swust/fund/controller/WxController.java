package com.swust.fund.controller;

import com.swust.fund.common.restful.ResponseJSON;
import com.swust.fund.common.restful.UnicomResponseEnums;
import com.swust.fund.service.WxService;
import com.swust.fund.utils.token.Token;
import com.swust.fund.utils.wx.WxRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: WxController
 * @Package com.swust.question.controller
 * @description: 微信相关操作接口
 * @date 2019/4/6 12:16
 */
@Api(tags = "微信相关操作接口")
@RestController
public class WxController {
    @Autowired
    private WxService wxService;

    @ApiOperation("微信小程序确认登录")
    @ApiImplicitParam(name = "code", value = "通过wx.login()获得的登录凭证", dataType = "string", paramType = "query", required = true)
    @RequestMapping(value = "/wx/confirm/login", method = RequestMethod.POST)
    @WxRequest
    public ResponseJSON<Map<String, String>> confirmLogin(String code) {
        return new ResponseJSON<>(true, wxService.login(code), UnicomResponseEnums.SUCCESS_OPTION);
    }
}
