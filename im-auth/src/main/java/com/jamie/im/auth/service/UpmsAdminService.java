package com.jamie.im.auth.service;

import com.jamie.im.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: jamie
 * @since v:1.0.0
 **/

@FeignClient("im-admin")
public interface UpmsAdminService {

    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);

}
