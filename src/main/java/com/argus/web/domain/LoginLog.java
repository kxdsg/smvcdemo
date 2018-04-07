package com.argus.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xingding on 18/4/7.
 */
public class LoginLog implements Serializable {

    private Integer loginLogId;
    private Integer userId;
    private String ip;
    private Date loginDate;

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
