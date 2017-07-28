package com.argus.web.core;

import java.util.Date;

/**
 * @author xingding
 * @date 17/7/28.
 */
class Employee{
    public Employee(){}
    public Employee(Date hireDay) {
        this.hireDay = hireDay;
    }

    public Employee(String name, Date hireDay) {
        this.name = name;
        this.hireDay = hireDay;
    }

    private String name;
    private Date hireDay;

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

    public int add(int a, int b){
        return a+b;
    }
}
