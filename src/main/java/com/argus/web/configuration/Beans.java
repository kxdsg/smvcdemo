package com.argus.web.configuration;

import com.argus.web.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xingding
 * @date 2017/12/3.
 */
//配置信息提供类
@Configuration
public class Beans {

    @Bean(name="car")
    public Car car(){
        Car car = new Car();
        car.setBrand("红旗");
        car.setColor("黑色");
        car.setMaxSpeed(10);
        return car;
    }
}
