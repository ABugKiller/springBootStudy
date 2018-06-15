package com.didispace.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}