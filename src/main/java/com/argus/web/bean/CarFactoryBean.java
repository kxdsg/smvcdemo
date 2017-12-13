package com.argus.web.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xingding
 * @date 2017/12/9.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private  String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    //接收逗号分隔的属性设置信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    //实例化Bean
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setColor(infos[1]);
        car.setMaxSpeed(Integer.parseInt(infos[2]));
        return car;
    }

    //返回Car的类型
    public Class<?> getObjectType() {
        return Car.class;
    }

    //标识通过FactoryBean返回的Bean是不是Singleton
    public boolean isSingleton() {
        return false;
    }
}
