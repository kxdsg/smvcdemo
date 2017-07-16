package com.argus.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xingding
 * @date 17/7/15.
 */
@Aspect
@Component
public class LogAspect {

    //controller包下所有的Controller中的所有方法
    @Pointcut("execution(* com.argus.web.controller..*.*(..))")
    public void printLog(){}

    @Around("printLog()")//环绕通知
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Silencing cell phones...");
            System.out.println("Take seats");
            jp.proceed();
            System.out.println("clap clap clap...");
        } catch (Throwable throwable) {
            System.out.println("demanding a refund");

        }
    }

}
