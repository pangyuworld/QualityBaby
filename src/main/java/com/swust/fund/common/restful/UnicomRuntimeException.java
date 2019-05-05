package com.swust.fund.common.restful;

/**
 * @program: question
 * @description: 自定义异常
 * @author: pang
 * @create: 2019-03-21 18:15
 * @version: v1.0
 **/
public class UnicomRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 返回码
     */
    protected String code;

    /**
     * 返回的信息
     */
    protected String msg;

    /**
     * 打印的日志信息
     */
    protected String message;

    public UnicomRuntimeException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public UnicomRuntimeException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public UnicomRuntimeException() {
        super();
    }

    public UnicomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnicomRuntimeException(String message) {
        super(message);
    }
}
