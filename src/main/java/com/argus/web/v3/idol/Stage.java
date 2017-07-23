package com.argus.web.v3.idol;

/**
 * @author xingding
 * @date 17/7/23.
 * 使用静态内部类创建Stage单例
 *
 * 如何在spring中注入这种没有公开构造方法的Bean呢？见beans.xml
 */
public class Stage {

    /*
    私有构造方法
     */
    private Stage(){}


    /*
    私有静态内部类，产生一个实例
     */
    private static class StageHolder{
        static Stage instance = new Stage();
    }

    /*
    公共方法外部使用
     */
    public static Stage getInstance(){
        return StageHolder.instance;
    }




}
