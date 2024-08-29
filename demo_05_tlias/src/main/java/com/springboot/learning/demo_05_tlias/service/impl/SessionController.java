package com.springboot.learning.demo_05_tlias.service.impl;

import com.springboot.learning.demo_05_tlias.utils.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//测试session
@Slf4j
@RestController
public class SessionController {
    @GetMapping("/C1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_username","xifangshibai"));//设置cookie
        return Result.success();
    }
    @GetMapping("/C2")
    public Result cookie2(HttpServletRequest request){
        Cookie[]  cookies= request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login_username")){
                System.out.println("login_username: "+cookie.getValue()); //输出设置的cookie的key:value
            }
        }
        return Result.success();
    }

    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1: {}", session.hashCode());

        session.setAttribute("loginUser", "tom"); //往session中存储数据
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser"); //从session中获取数据
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }

}
