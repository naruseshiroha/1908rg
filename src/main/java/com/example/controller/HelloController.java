package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${key:key}")
    private String key;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello, " + key + ".";
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

}
