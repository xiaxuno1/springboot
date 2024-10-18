package com.springboot.learning.demo_05_tlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //通过这个注解来开启SpringBoot项目对于Servlet组件的支持。实现filter过滤器功能
@SpringBootApplication
public class Demo05TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo05TliasApplication.class, args);
    }

}
