package com.springboot.learning.demo_05_tlias.controller;


import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.service.LoginService;
import com.springboot.learning.demo_05_tlias.utils.JwtUtils;
import com.springboot.learning.demo_05_tlias.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        Emp e = loginService.login(emp);
        log.info("登录，emp:{}",emp);
        //登录成功后，生成jwt令牌，返回data
        if (e != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());

            String token= JwtUtils.generateJwt(claims);//生成jwt令牌
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }
}
