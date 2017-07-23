package com.argus.web.v3.idol;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author xingding
 * @date 17/7/23.
 */
public class Audience {

    public void takeSeats(){
        System.out.println("take seats...");
    }

    public void applaud(){
        System.out.println("clap clap clap...");
    }

    public void demandRefund(){
        System.out.println("demand refund...");
    }

    public void watchPerformance(ProceedingJoinPoint pj){
        try {
            System.out.println("audience take seats...");
            long start = System.currentTimeMillis();
            pj.proceed();
            long end = System.currentTimeMillis();
            System.out.println("audience clap clap clap...");
            System.out.println("the performance take " + (end - start) + " ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.err.println("audience demand refund...");
        }

    }
}
