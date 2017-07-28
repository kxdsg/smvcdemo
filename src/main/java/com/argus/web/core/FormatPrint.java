package com.argus.web.core;

import java.util.Date;

/**
 * @author xingding
 * @date 17/7/26.
 */
public class FormatPrint {
    public static void main(String[] args) {
//        System.out.printf("%8.2f",100.1);
//        System.out.printf("%x",1000);
//        System.out.printf("Hello %s", "kk");
//        System.out.println(String.format("hello %s","bonnie"));
//        System.out.printf("%tm",new Date());
        System.out.println(String.format("%td",new Date()));
    }
}
