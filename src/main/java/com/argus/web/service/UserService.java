package com.argus.web.service;

import com.argus.web.dao.LoginLogDao;
import com.argus.web.dao.UserDao;
import com.argus.web.domain.LoginLog;
import com.argus.web.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xingding on 18/4/7.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    public void loginSuccess(User user){
        user.setCredits( 5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
