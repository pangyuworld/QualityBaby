package com.swust.fund.common.restful;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: question
 * @description: 统一返回json格式
 * @author: pang
 * @create: 2019-03-21 18:14
 * @version: v1.0
 **/
@ApiModel("统一返回样式")
public class ResponseJSON<T> {
    @ApiModelProperty("是否成功")
    private boolean success;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty("错误码")
    private String errCode;
    @ApiModelProperty("错误信息")
    private String errMsg;


    public ResponseJSON() {
    }

    public ResponseJSON(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseJSON{" +
                "success=" + success +
                ", data=" + data +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    public ResponseJSON(boolean success, T data, String errCode, String errMsg) {
        super();
        this.success = success;
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResponseJSON(boolean success, String errCode, String errMsg) {
        this.success = success;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResponseJSON(boolean success, UnicomResponseEnums enums) {
        this.success = success;
        this.errCode = enums.getCode();
        this.errMsg = enums.getMsg();
    }

    public ResponseJSON(boolean success, T data, UnicomResponseEnums enums) {
        this.success = success;
        this.data = data;
        this.errCode = enums.getCode();
        this.errMsg = enums.getMsg();
    }

    public boolean isSuccess() {
        return success;
    }

    public ResponseJSON<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }


    public String getErrCode() {
        return errCode;
    }

    public ResponseJSON<T> setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public ResponseJSON<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseJSON<T> setData(T data) {
        this.data = data;
        return this;
    }
}
