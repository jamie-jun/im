//package com.jamie.im.auth.controller;
//
//import com.jamie.im.common.response.ResponseResult;
//import com.jamie.im.common.web.Header;
//import com.jamie.im.auth.controller.param.LoginParam;
//import com.jamie.im.auth.service.ILoginService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author: jamie
// * @since v:1.0.0
// **/
//@RestController
//@RequestMapping(value = "login")
//public class LoginController {
//
//    @Resource
//    private HttpServletRequest request;
//
//    @Resource
//    private ILoginService loginService;
//
//    /**
//     * 管理员登陆
//     * @param loginParam
//     * @return
//     */
//    @PostMapping("admin")
//    public ResponseResult admin(@RequestBody LoginParam loginParam){
//        return ResponseResult.success(loginService.getToken(loginParam.getUsername(),loginParam.getPassword()));
//    }
//
//    /**
//     * 用户登陆，登陆只是那 Token
//     * @param loginParam
//     * @return
//     */
//    @PostMapping("user")
//    public ResponseResult user(@RequestBody LoginParam loginParam){
//        return ResponseResult.success(loginService.getToken(loginParam.getUsername(),loginParam.getPassword()));
//    }
//
//    /**
//     * 刷新令牌
//     * @return
//     */
//    @PostMapping("refresh")
//    public ResponseResult refresh(){
//        String token = Header.getAuthorization(request.getHeader("Authorization"));
//        return  ResponseResult.success(loginService.refresh(token));
//    }
//
//}
