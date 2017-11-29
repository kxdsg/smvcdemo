package com.argus.web.controller;

import com.argus.web.annotation.HeaderExtProp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xingding
 * @date 17/7/15.
 */
@Controller
public class HelloController {

    @HeaderExtProp
    @GetMapping("/hello")
    public String hello(Model model, HttpServletRequest request){
        System.out.println("ip: " + request.getAttribute("ip") );
        model.addAttribute("msg","kk");
        return "hello";
    }

}
