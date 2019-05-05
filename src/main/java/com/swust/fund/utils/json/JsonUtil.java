package com.swust.fund.utils.json;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: JsonUtil
 * @Package com.swust.question.utils.http
 * @description: json数据操作工具包
 * @date 2019/4/6 12:35
 */
public class JsonUtil {
    public static Map<String,String> json2Map(JSONObject jsonObject){
        Set<String> keySet=jsonObject.keySet();
        Map<String,String> result=new HashMap<>();
        for (String str:keySet){
            result.put(str,jsonObject.getString(str));
        }
        return result;
    }
}
