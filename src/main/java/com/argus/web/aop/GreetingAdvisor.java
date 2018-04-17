package com.argus.web.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by xingding on 18/4/14.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{
    public boolean matches(Method method, Class<?> aClass) {
        return "serveTo".equals(method.getName());//只针对serverTo方法采用增强
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
