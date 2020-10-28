package com.jamie.im.admin.service;

import com.jamie.im.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: jamie
 * @since v:1.0.0
 **/

@FeignClient("im-auth")
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    Map getAccessToken(@RequestParam Map<String, String> parameters);

    @PostMapping("/auth/logout")
    ResponseResult logout();

}
