package com.argus.web.service;

import com.argus.web.config.SpringConfig;
import com.argus.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
