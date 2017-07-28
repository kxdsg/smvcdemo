package com.argus.web.core;

import java.util.Date;

/**
 * @author xingding
 * @date 17/7/27.
 */
public class MultiVar {

    public void multi(Object ... args){
        for(Object obj: args){
            System.out.println(obj);
        }
    }

    public static double max(double... args){
        double largest = Double.MIN_VALUE;
        for(double d: args){
            if(d>largest){
                largest =d;
            }
        }
        return largest;
    }

    public void classInfo(){
        MultiVar v = new MultiVar();
        Class c = v.getClass();
        System.out.println(c.getName());
    }

    public static void main(String[] args) throws Exception{
//        MultiVar v = new MultiVar();
        MultiVar v = MultiVar.class.newInstance();
//        Object  c = Class.forName("com.argus.web.core.MultiVar").newInstance();
//        System.out.println(c);
        v.multi("a","b","c");
        System.out.println(max(1.0,2.5,2.3));
        v.classInfo();
    }

}
