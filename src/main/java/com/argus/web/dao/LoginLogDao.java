package com.argus.web.dao;

import com.argus.web.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xingding on 18/4/7.
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sqlStr = "insert into t_login_log(user_id, ip, login_datetime ) values (?,?,?)";
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr,args);
    }
}
