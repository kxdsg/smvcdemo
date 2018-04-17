package com.argus.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by xingding on 18/4/14.
 */
public class GreetingAroundInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("hello, " + clientName);
        Object obj = methodInvocation.proceed();
        System.out.println("enjoy!");
        return obj;
    }
}
