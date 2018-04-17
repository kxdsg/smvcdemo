package com.argus.web.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by xingding on 18/4/15.
 */
@Aspect
public class GreetingAspect {

    @Before("execution(* serveTo(..))")
    public void beforeGreeting(){
        System.out.println("how are you!");
    }
}
