package com.springboot.learning.demo_01_quickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello,world!!"); //控制台打印
        return "hello,world!!"; //返回给浏览器，在浏览器展示
    }
}
