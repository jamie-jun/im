package com.jamie.im.auth.controller;

import com.jamie.im.common.response.ResponseCode;
import com.jamie.im.common.response.ResponseResult;
import com.jamie.im.common.web.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: jamie
 * @since v:1.0.0
 **/

@RestController
@RequestMapping(value = "auth")
public class LogoutController {

    @Resource
    private TokenStore tokenStore;

    @Resource
    private HttpServletRequest request;

    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;

    /**
     * 注销管理员
     * @return
     */
    @PostMapping("/logout")
    public ResponseResult logout(){
        String token = Header.getAuthorization(request.getHeader("Authorization"));

//        if(consumerTokenServices.revokeToken(token)) {
//            return ResponseResult.success();
//        }
//        else {
//            return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
//        }
        //删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        if(null != oAuth2AccessToken){
            tokenStore.removeAccessToken(oAuth2AccessToken);
            return ResponseResult.success();
        }
        return ResponseResult.failure(ResponseCode.INTERFACE_ADDRESS_INVALID);
    }

}
