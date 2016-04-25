package com.mytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用来做跳转的工具类
 * Created by hebo on 2016/4/6.
 */

@Controller
public class JumpController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/message")
    public String message(){
        return "message";
    }


}
