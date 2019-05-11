package com.swust.fund.service;

import com.swust.fund.common.CommonConst;
import com.swust.fund.utils.http.HttpUtil;
import com.swust.fund.utils.json.JsonUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: WxService
 * @Package com.swust.question.service
 * @description: 微信操作业务层
 * @date 2019/4/6 12:17
 */
@Service
public class WxService {

    /**
     * 微信小程序登录验证
     *
     * @param code wx.login接口获得的登录凭证
     * @return com.fasterxml.jackson.databind.util.JSONPObject
     * @author pang
     * @date 2019/4/6
     */
    public Map<String, String> login(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("appid", CommonConst.appletId);
        params.put("secret", CommonConst.appletSecret);
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        String jsonPackage = HttpUtil.getByHttp(String.class, "/sns/jscode2session", params);
        Map<String, String> result = new HashMap<>();
        result = JsonUtil.json2Map(JsonUtil.str2Json(jsonPackage));
        return result;
    }
}
