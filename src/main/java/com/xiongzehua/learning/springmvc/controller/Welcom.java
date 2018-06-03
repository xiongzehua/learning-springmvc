package com.xiongzehua.learning.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 31339 on 2018/5/31.
 */
@Controller
public class Welcom {
    @RequestMapping("/welcom")
    public ModelAndView welcom() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("productlist.html");
        return mv;
    }
}
