package com.qfedu.wjt.interceptor;

import com.qfedu.wjt.pojo.User;
import com.qfedu.wjt.utils.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        User user = (User)request.getSession().getAttribute(StrUtils.LOGIN_USER);
        if (user == null) {
            String value = request.getHeader("X-Requested-With");
            System.out.println(value);
            if (value != null && value.equals("XMLHttpRequest")) {
                response.getWriter().write("{'code':0,'info':'未登录'}");
            } else {
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
            return false;
        } else {
            return true;
        }
    }
}
