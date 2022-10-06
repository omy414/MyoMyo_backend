package com.suda.backend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * @apiNote 기본 인터셉터 클래스, API KEY가 헤더에 있는지 체크.
 * @author Dratini
 * @since 2022.10.05
 * @version 1.0
 */
@Component
public class MyoMyoInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% [preHandle]");
        // 요청 헤더 내, apiKey 검색
        if (!(request.getHeader("apiKey").equals(null) || request.getHeader("apiKey").equals(""))) {
            // apiKey 를 이용하여 일치하는 데이터가 있는지 검색
            String apiKey = request.getHeader("apiKey").toString();
            if ("test".equals(apiKey)) {
                // 있는 경우 요청 진행
                return true;
            } else {
                // 없는 경우 에러
                response.sendRedirect("/error");
                return false;
            }
        } else {
            response.sendRedirect("/error");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("[postHandle]");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
            throws Exception {
        System.out.println("[afterCompletion]");
    }
}
