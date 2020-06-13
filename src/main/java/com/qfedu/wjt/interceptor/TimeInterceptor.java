package com.qfedu.wjt.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeInterceptor implements HandlerInterceptor {
    private long beginTime;
    private long endTime;
    @Override
    //请求到之后进行拦截，true放行，false不在继续访问
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        long beginTime = System.currentTimeMillis();
        return true;
    }

    @Override
    //访问过相关资源，页面渲染之前执行此方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    //页面渲染之后的执行的方法
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        long endTime = System.currentTimeMillis();
        long v = endTime - beginTime;
        System.out.println(v);
    }
}
