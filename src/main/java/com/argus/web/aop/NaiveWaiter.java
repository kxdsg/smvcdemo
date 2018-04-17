package com.argus.web.aop;

/**
 * Created by xingding on 18/4/14.
 */
public class NaiveWaiter implements Waiter {

    public void serveTo(String name) {
        System.out.println("serve to " + name + "...");
    }

    public void ask(String name) {
        System.out.println("ask to " + name + "...");
    }
}
