package com.argus.web.main;

import com.argus.web.bean.Car;
import com.argus.web.configuration.Beans;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 加载bean的方式测试
 * @author xingding
 * @date 2017/12/3.
 */
public class MainApplication {

    public static void main(String[] args) {
        //通过xml配置的方式获取bean
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml","applicationContext.xml");
//        Car car = ctx.getBean("car1",Car.class);
//        System.out.println(car.toString());

//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resolver.getResource("classpath:beans.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        System.out.println("init bean factory");
//        Car car = factory.getBean("car",Car.class);
//        System.out.println(car.toString());

        //通过java配置信息类的方式获取bean
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.register(Beans.class);
        ctx2.refresh();
        Car car2 = ctx2.getBean("car",Car.class);
        System.out.println(car2.toString());
    }
}
