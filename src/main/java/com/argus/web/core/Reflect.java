package com.argus.web.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author xingding
 * @date 17/7/28.
 */

public class Reflect {

    public static void main(String[] args) {
        try {
            Employee e = new Employee("kk",new Date());
            Class c = e.getClass();
            Field[] fs = c.getDeclaredFields();
            for(Field i: fs){
                System.out.printf("Field name is %s, Type is %s", i.getName(), i.getType());
            }
            System.out.println();
            System.out.printf("Class Name is %s",c.getName());
            System.out.println();
            Field f = c.getDeclaredField("name");
            f.setAccessible(true);//访问私有域
            f.set(e,"kangkang");//修改值
            Object o = f.get(e);//读取值
            System.out.println(o.toString());

            Method m = c.getDeclaredMethod("add",int.class,int.class);//获取方法
            Object o2 = m.invoke(e, 1,2);//method.invoke(对象名,参数...)
            System.out.println(o2.toString());


        } catch (Exception e1) {
            e1.printStackTrace();
        }


        try {
            String es = "com.argus.web.core.Employee";
            Class c2 = Class.forName(es);
            Employee e2 = (Employee)c2.newInstance();
            System.out.println(c2.getName());
            e2.setHireDay(new Date());
            System.out.println(e2.getHireDay());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        Class c3 = Employee.class;
        System.out.println(c3.getName());
        System.out.println(c3.getModifiers());



    }


}