package com.argus.web.controller;

import com.argus.web.domain.User;
import com.argus.web.service.UserService;
import com.argus.web.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by xingding on 18/4/7.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.do")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.do")
    public ModelAndView loginCheck(HttpServletRequest request, Login login){
        boolean isValid = userService.hasMatchUser(login.getUserName(), login.getPassword());
        if(!isValid){
            return new ModelAndView("login","error","用户名或密码错误");
        } else {
            User user = userService.findUserByUserName(login.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }

    }
}
