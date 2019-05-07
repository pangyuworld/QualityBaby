package com.swust.fund.utils.http;

import com.swust.fund.common.CommonConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: HttpUtil
 * @Package com.swust.question.utils.http
 * @description: Http访问工具
 * @date 2019/3/21 21:40
 */

public class HttpUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 进行GET形式的http访问
     *
     * @param responseType 返回的参数类型
     * @param url          目标地址
     * @return T
     * @author pang
     * @date 2019/3/21
     */
    @RequestMapping("getForEntity")
    public static <T> T getByHttp(Class<T> responseType, String url) throws HttpClientErrorException {
        T result = (T) restTemplate.getForObject(CommonConst.baseURL + url, responseType);
        LOGGER.info("访问API , method = GET , url = " + url);
        return result;
    }

    /**
     * 带参数进行get访问
     *
     * @param responseType 返回的参数类型
     * @param url          目标地址
     * @param params       参数
     * @return T
     * @author pang
     * @date 2019/3/21
     */
    @RequestMapping("getForEntity")
    public static <T> T getByHttp(Class<T> responseType, String url, Map<String, String> params) throws HttpClientErrorException {
        StringBuffer sb = new StringBuffer(url);
        sb.append("?");
        Set<String> paramKey = params.keySet();
        for (String str : paramKey) {
            sb.append(str + "=" + params.get(str) + "&");
        }
        T result = (T) restTemplate.getForObject(CommonConst.baseURL + sb, responseType, params);
        LOGGER.info("访问API , method = GET , url = " + CommonConst.baseURL + url + " ,params : " + params);
        return result;
    }


    /**
     * 通过post方式进行访问
     *
     * @param responseType 返回值类型
     * @param url          目标网址
     * @param params       参数
     * @return T
     * @author pang
     * @date 2019/3/21
     */
    @RequestMapping("postForEntity")
    public static <T> T postByHttp(Class<T> responseType, String url, Object params) throws HttpClientErrorException {
        T result = (T) restTemplate.postForObject(CommonConst.baseURL + url, params, responseType);
        LOGGER.info("访问API , method = POST , url = " + url + " , params = " + params);
        return result;
    }


}
