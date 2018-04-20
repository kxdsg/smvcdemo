package com.argus.web.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xingding on 18/4/17.
 */
public class TUser {
    private Integer id;
    private String name;
    private String sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
    private String address;
    private String email;
    private String remark;
    private String userLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", userLevel='" + userLevel + '\'' +
                '}';
    }
}
