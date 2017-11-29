package com.argus.web.intercept;

import com.argus.web.annotation.HeaderExtProp;
import com.argus.web.util.ListUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author xingding
 * @date 2017/11/28.
 */
public class CustomeHeaderInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor....");
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            HeaderExtProp headerExtProp = ((HandlerMethod) handler).getMethodAnnotation(HeaderExtProp.class);
            //如果方法设置了注解@HeaderExtProp，做特殊处理
            if (headerExtProp != null) {
                System.out.println("set ip attribute...");
                request.setAttribute("ip","192.168.1.3");

            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
