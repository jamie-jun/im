package com.jamie.im.common.exception;

import com.jamie.im.common.response.ResponseCode;
import lombok.Data;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1085171837874876782L;

    private Integer code;

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
        this.code = -1;
    }

    public BusinessException(ResponseCode status){
        super(status.message());
        this.code = status.code();
    }
}
