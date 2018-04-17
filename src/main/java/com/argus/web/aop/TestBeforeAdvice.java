package com.argus.web.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xingding on 18/4/14.
 */
public class TestBeforeAdvice {
    public static void main(String[] args) {
        /*
        Waiter target = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();

        //spring代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);

        Waiter proxy = (Waiter)proxyFactory.getProxy();
        proxy.serveTo("Tony");
        */

        /*
        //Spring AOP测试
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml","applicationContext.xml");
        Waiter waiter = (Waiter)ctx.getBean("waiter");
//        Waiter waiter = (Waiter)ctx.getBean("waiter1");
        waiter.serveTo("Tony");
//        waiter.ask("Caleb");
        */

        //Aspect测试
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();

        aspectJProxyFactory.setTarget(target);
        aspectJProxyFactory.addAspect(GreetingAspect.class);
        Waiter proxy = aspectJProxyFactory.getProxy();
        proxy.serveTo("Bonnie");


    }
}
