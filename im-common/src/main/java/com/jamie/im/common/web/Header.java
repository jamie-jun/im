package com.jamie.im.common.web;

import com.jamie.im.common.exception.BusinessException;
import com.jamie.im.common.response.ResponseCode;
import org.springframework.util.StringUtils;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
public class Header {

    private static final String AUTHORIZATION_BEARER_TOKEN = "Basic ";

    /**
     * 获取Token
     * @param header request.getHeader("Authorization")
     * @return token
     */
    public static String getAuthorization(String header){
        if(StringUtils.isEmpty(header) || header.startsWith(AUTHORIZATION_BEARER_TOKEN)){
            throw new BusinessException(ResponseCode.USER_NOT_LOGGED_IN);
        }
        return header.substring(AUTHORIZATION_BEARER_TOKEN.length()+ 1);
    }
}
