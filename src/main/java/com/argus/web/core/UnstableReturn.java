package com.argus.web.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xingding
 * @date 17/7/27.
 */
public class UnstableReturn
{
    public static void main(String[] args) throws Exception {
        Employee harry = new Employee(new SimpleDateFormat("yyyy-MM-hh").parse("2008-03-24"));
        Date d = harry.getHireDay();
        double tenYearsInMs = 10 * 365.25 * 24 * 60 * 60 * 1000;
        d.setTime(d.getTime()-(long)tenYearsInMs);
        System.out.println(d); //
        System.out.println(harry.getHireDay()); //harry的封装数据被破坏了，缩减了10年

    }

}


