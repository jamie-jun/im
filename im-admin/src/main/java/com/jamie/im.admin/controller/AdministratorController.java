package com.jamie.im.admin.controller;

import com.jamie.im.admin.domain.Administrator;
import com.jamie.im.admin.dto.AdminAddParam;
import com.jamie.im.admin.dto.AdminCommonParam;
import com.jamie.im.admin.dto.LoginParam;
import com.jamie.im.admin.service.AuthService;
import com.jamie.im.admin.service.MenuService;
import com.jamie.im.admin.service.AdministratorService;
import com.jamie.im.common.base.BaseController;
import com.jamie.im.common.dto.UserDto;
import com.jamie.im.common.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
* 用户表 前端控制器
* </p>
*
* @author jamie
* @since 2020-09-25
*/
@RestController
@RequestMapping("admin")
public class AdministratorController extends BaseController<Administrator, AdministratorService> {

    @Autowired
    private AdministratorService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam String username) {
        return userService.loadUserByUsername(username);
    }

    @PostMapping("/login")
    public ResponseResult login(@Validated @RequestBody LoginParam loginParam) {
        return userService.login(loginParam.getUsername(), loginParam.getPassword());
    }

    @GetMapping("/info")
    public ResponseResult getAdminInfo() {
        UserDto user = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> data = new HashMap<>();
        data.put("name", user.getUsername());
        data.put("avatar", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=571266658,3921401833&fm=11&gp=0.jpg");
        data.put("roles",user.getRoles());
        data.put("menus",menuService.findByUserId(user.getId()));
        return ResponseResult.success(data);
    }

    @PostMapping("/register")
    public ResponseResult register(@Validated @RequestBody AdminAddParam adminParam){
         Administrator user = userService.register(adminParam);
        return ResponseResult.success(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
//        authService.logout();
        return ResponseResult.success();
    }

    @GetMapping("/list")
    public ResponseResult list(@RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return ResponseResult.success(userService.list(keyword,pageSize,pageNum));
    }

    @PutMapping("/updateUser")
    public ResponseResult updateUser(@Validated @RequestBody AdminCommonParam updateParam){
        return ResponseResult.success(userService.updateUser(updateParam));
    }

    @DeleteMapping("/del")
    public ResponseResult del(@RequestParam Long id){
        return ResponseResult.success(userService.del(id));
    }
}