package com.argus.web.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by xingding on 18/4/17.
 * 演示private/final/static方法没有引入事务增强
 */
@Service
public class TxCounterService {

    //private
    private void method1(){
        System.out.println("method1");
    }

    //final
    public final void method2(){
        System.out.println("method2");
    }

    //static
    public static void method3(){
        System.out.println("method3");
    }

    public void method4(){
        System.out.println("method4");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml","beans.xml");
        TxCounterService txCounterService = (TxCounterService)ctx.getBean("txCounterService");
        System.out.println("before method1");
        txCounterService.method1();
        System.out.println("after method1");
        System.out.println("before method2");
        txCounterService.method2();
        System.out.println("after method2");
        System.out.println("before method3");
        txCounterService.method3();
        System.out.println("after method3");
        System.out.println("before method4");
        txCounterService.method4();
        System.out.println("after method4");
    }

}
