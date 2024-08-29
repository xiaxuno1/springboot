package com.springboot.learning.demo_05_tlias.config;

import com.springboot.learning.demo_05_tlias.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//**注册配置拦截器**interceptor
@Configuration//注册配置类
@EnableAspectJAutoProxy //显示配置Aspect aop
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器对象
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**") //拦截器的匹配路径 /**表示所有路径
                .excludePathPatterns("/login"); //排除路径
    }
}
