package com.selfStudy.core.interceptor;

import com.selfStudy.core.pojo.SsAdmin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptors extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String URI = request.getRequestURI();
        int code = URI.indexOf("/login");
        if(code>=0){
            return true;
        }
        SsAdmin user = (SsAdmin) session.getAttribute("ADMIN");
        if (user != null) {
            return true;
        }
        response.sendRedirect("/logins");
        return false;
    }
}
