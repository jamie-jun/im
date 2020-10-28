//package com.jamie.im.admin.handler;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: jamie
// * @since v:1.0.0
// **/
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//
//    @Override
//    public void handle(HttpServletRequest request,
//                       HttpServletResponse response,
//                       AccessDeniedException e) throws IOException {
//        JSONObject json=new JSONObject();
//        json.put("code",403);
//        json.put("msg","没有权限");
//        response.setHeader("Content-type", "text/html;charset=UTF-8");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().write(JSONObject.toJSONString(json));
//    }
//}
