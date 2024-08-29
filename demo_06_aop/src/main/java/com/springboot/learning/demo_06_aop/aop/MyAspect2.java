package com.springboot.learning.demo_06_aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(2)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect2 {
    //引用MyAspect1切面类中的切入点表达式
    @Before("com.springboot.learning.demo_06_aop.aop.MyAspect1.pt()")
    public void before(){
        log.info("MyAspect2 -> before ...");
    }
}
