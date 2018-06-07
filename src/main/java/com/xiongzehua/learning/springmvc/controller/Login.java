package com.xiongzehua.learning.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiongzehua on 2018/6/1.
 */


@Controller
public class Login {
    /**
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    //使用@RequestParam("key")拿到post中对于的value传入注解的变量中
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {

        if ("admin".equals(account) && "123456".equals(password))
            return "/web-resources/welcome.html";
        else
            return "/web-resources/login_error.html";
    }
}
