package com.argus.web.jdbc;

import com.argus.web.domain.TUser;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xingding on 18/4/17.
 */
public class JdbcTemplateTest {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("admin123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        /*
        String sql = "insert into user(name, sex, birthday,address) values ('kk', 'f','1986-06-24','jx')";
        jdbcTemplate.execute(sql);
        */

        /* 不建议使用
        String sql = "insert into user(name, sex, birthday,address) values (?,?,?,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"caleb");//索引从1开始
                preparedStatement.setString(2,"m");
                preparedStatement.setString(3,"1983-01-01");
                preparedStatement.setString(4,"sg");
            }
        });
        */

        //建议使用
        /*
        String sql = "insert into user(name, sex, birthday,address) values (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"chin","m","1980-10-01","hk"});
        */

        /*返回主键
        final String sql = "insert into user(name, sex, birthday,address) values (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1,"liang");
                pstmt.setString(2,"f");
                pstmt.setString(3,"1988-09-18");
                pstmt.setString(4,"hn");
                return pstmt;
            }
        },keyHolder);
        System.out.println(keyHolder.getKey().intValue());
        */

        /*
        查询
         */

        /*
        final TUser user = new TUser();
        String sql = "select name, sex,birthday from user where name = ?";
        jdbcTemplate.query(sql, new Object[]{"caleb"}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setName(resultSet.getString(1));
                user.setSex(resultSet.getString(2));
                user.setBirthDay(resultSet.getDate(3));
            }
        });
        System.out.println(user.toString());
        */

        /*查询返回多行数据*/
        String sql = "select name,sex,birthday from user where id > ?";
        List<TUser> userList = jdbcTemplate.query(sql, new Object[]{1}, new RowMapper<TUser>() {
            public TUser mapRow(ResultSet resultSet, int i) throws SQLException {
                TUser user = new TUser();
                user.setName(resultSet.getString(1));
                user.setSex(resultSet.getString(2));
                user.setBirthDay(resultSet.getDate(3));
                return user;
            }
        });
        System.out.println(userList.size());
    }
}
