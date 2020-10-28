package com.jamie.im.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -40917226067978081L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 异常
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String throwable;

    /**
     * 需要返回的数据对象
     */
    private Object data ;

    public  ResponseResult() {
        super();
    }

    /**
     * 一般的响应结果，不返回数据
     * @param code
     */
    public  ResponseResult(ResponseCode code) {
        super();
        this.code = code.code();
        this.message = code.message();
    }

    /**
     * 一般的响应结果，不返回数据自定义消息
     * @param code
     * @param message
     */
    public  ResponseResult(ResponseCode code,String message) {
        super();
        this.code = code.code();
        this.message = message;
    }

    /**
     * 一般的响应结果，包含数据
     * @param code
     * @param data
     */
    public  ResponseResult(ResponseCode code,Object data) {
        super();
        this.code = code.code();
        this.message = code.message();
        this.data = data;
    }

    /**
     * 一般的响应结果，自定义消息并包含数据
     * @param code
     * @param message
     * @param data
     */
    public  ResponseResult(ResponseCode code,String message,Object data) {
        super();
        this.code = code.code();
        this.message = message;
        this.data = data;
    }

    /**
     * 异常的响应结果，返回的对象会包含throwable字段
     * @param code
     * @param throwable
     */
    public  ResponseResult(ResponseCode code,Throwable throwable) {
        super();
        this.code = code.code();
        this.message = message;
        this.throwable = throwable.getMessage();
    }

    /**
     * 请求成功
     * @return
     */
    public static  ResponseResult success(){
        return new ResponseResult(ResponseCode.SUCCESS);
    }

    /**
     * 请求成功
     * @param massage
     * @return
     */
    public static  ResponseResult success(Object massage){
        return new ResponseResult(ResponseCode.SUCCESS,massage);
    }

    /**
     * 请求失败
     * @param message
     * @return
     */
    public static  ResponseResult failure(String message){
        return new ResponseResult(ResponseCode.FAILURE,message);
    }

    public static  ResponseResult failure(ResponseCode responseCode){
        return new ResponseResult(responseCode);
    }

}
