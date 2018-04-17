package com.argus.web.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by xingding on 18/4/14.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "." + method.getName());
        String clientName = (String)objects[0];
        System.out.println("how are you! Mr." + clientName + ".");
    }
}
