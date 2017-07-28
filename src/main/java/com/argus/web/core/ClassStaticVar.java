package com.argus.web.core;

/**
 * @author xingding
 * @date 17/7/27.
 */
public class ClassStaticVar {

    private static int nextId = 1;
    private int id;

    public void setId() {
        id = nextId;
        nextId++;
    }

    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            ClassStaticVar c = new ClassStaticVar();
            c.setId();
            System.out.println(ClassStaticVar.nextId);
        }
    }
}




