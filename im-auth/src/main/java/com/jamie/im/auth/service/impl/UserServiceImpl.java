package com.jamie.im.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jamie.im.auth.service.UpmsAdminService;
import com.jamie.im.common.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jamie
 * @since v:1.0.0
 **/
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UpmsAdminService upmsAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //认证
        UserDto user = upmsAdminService.loadUserByUsername(username);
        if(user == null) {
            //如果查询不到用户，返回null,由provider来抛异常
            return null;
        }
        //授权
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        user.getRoles().stream()
                .forEach(p -> grantedAuthorities.add(new SimpleGrantedAuthority(p)));
        //将UserDto转成json
        String principal = JSONObject.toJSONString(user);
        return new User(principal,user.getPassword(),grantedAuthorities);
    }
}
