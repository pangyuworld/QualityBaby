package com.swust.fund.common.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * @program: question
 * @description: 全局异常处理类
 * @author: pang
 * @create: 2019-03-21 18:16
 * @version: v1.0
 **/
// @RestControllerAdvice(annotations = {RestController.class})
public class SpringExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(SpringExceptionHandle.class);

    /**
     * 请求参数类型错误异常的捕获
     *
     * @param e
     * @return com.swust.question.common.restful.ResponseJSON<java.lang.String>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {BindException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseJSON<String> badRequest(BindException e) {
        logger.error("请求参数错误 ,message {}", e.getMessage());
        return new ResponseJSON<>(false, e.getMessage(), UnicomResponseEnums.BAD_REQUEST);
    }

    /**
     * 404错误异常的捕获
     *
     * @param e
     * @return com.swust.question.common.restful.ResponseJSON<java.lang.String>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseJSON<String> badRequestNotFound(BindException e) {
        logger.error("资源未找到 ,message {}", e.getMessage());
        return new ResponseJSON<>(false, e.getMessage(), UnicomResponseEnums.NOT_FOUND);
    }


    /**
     * 自定义异常的捕获
     * 自定义抛出异常。统一的在这里捕获返回JSON格式的友好提示。
     *
     * @param exception
     * @param request
     * @return com.swust.question.common.restful.ResponseJSON<T>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {UnicomRuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public <T> ResponseJSON<T> sendError(UnicomRuntimeException exception, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        logger.error("发生错误 url ={} ,message {}", requestURI, exception.getMsg());
        return new ResponseJSON<>(false, exception.getCode(), exception.getMsg());
    }

    /**
     * 数据库操作出现异常
     *
     * @param e
     * @return com.swust.question.common.restful.ResponseJSON<java.lang.String>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {SQLException.class, DataAccessException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseJSON<String> systemError(Exception e) {
        logger.error("数据库操作异常 ,message {}", e.getMessage());
        return new ResponseJSON<>(false, e.getMessage(), UnicomResponseEnums.DATABASE_ERROR);
    }

    /**
     * 网络连接失败！
     *
     * @param e
     * @return com.swust.question.common.restful.ResponseJSON<java.lang.String>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {ConnectException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseJSON<String> connect(Exception e) {
        logger.error("网络连接失败 ,message {}", e.getMessage());
        return new ResponseJSON<>(false, e.getMessage(), UnicomResponseEnums.CONNECTION_ERROR);
    }

    /**
     * 未知错误
     *
     * @param e
     * @return com.swust.question.common.restful.ResponseJSON<java.lang.String>
     * @author pang
     * @date 2019/3/22
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseJSON<String> notAllowed(Exception e) {
        logger.error("发生未知错误 ,message {}", e.getMessage());
        return new ResponseJSON<>(false, e.getMessage(), UnicomResponseEnums.METHOD_NOT_ALLOWED);
    }
}
