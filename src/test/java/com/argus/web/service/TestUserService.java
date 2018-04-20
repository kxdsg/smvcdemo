package com.argus.web.service;

import com.argus.web.config.SpringConfig;
import com.argus.web.domain.TUser;
import com.argus.web.domain.User;
import com.argus.web.mapper.UserMapper;
import com.argus.web.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingding on 18/4/7.
 */
@RunWith(SpringJUnit4ClassRunner.class) //基于Junit4的spring测试框架
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void listUsers(){
        Map params = new HashMap();
        List<TUser> userList = userMapper.listUsers(params);
        for(TUser user: userList){
            System.out.println("birthDay: " + user.getBirthDay());
            System.out.println(user.toString());
        }
    }

    @Test
    public void listUsersSpec(){
        Map params = new HashMap();
        List<UserVo> userList = userMapper.listUsersSpec(params);
        for(UserVo user: userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        assertTrue(b1);
    }

    @Test
    public void findUserByUserName(){
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }
}
