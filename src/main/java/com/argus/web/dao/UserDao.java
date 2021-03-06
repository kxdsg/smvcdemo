package com.argus.web.dao;

import com.argus.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xingding on 18/4/7.
 */
@Repository //通过spring注解定义一个DAO
public class UserDao {
    @Autowired //自动注入JdbcTemplate的Bean
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password){
        String sqlStr = "select count(0) from t_user where user_name = ? and password = ? ";
        return jdbcTemplate.queryForObject(sqlStr,new Object[]{userName,password},Integer.class);
    }


    public User findUserByUserName(final String userName){
        String sqlStr = "select user_id, user_name, credits from t_user where user_name = ? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }


    public void updateLoginInfo(User user){
        String sqlStr = "update t_user set last_visit = ?, last_ip = ?, credits = ? where user_id = ? ";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(), user.getLastIp(),
                                user.getCredits(), user.getUserId()});
    }
}
