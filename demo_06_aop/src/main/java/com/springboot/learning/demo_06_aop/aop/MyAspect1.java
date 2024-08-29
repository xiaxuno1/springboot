package com.springboot.learning.demo_06_aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(1)  //切面类的执行顺序（前置通知：数字越小先执行; 后置通知：数字越小越后执行）
public class MyAspect1 {

//    @Pointcut 抽取出所有的切入点的表达式成为方法，后续调用方法即可，也可以在其他类中使用见MyAspect2
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

    @Before("pt()")
    public void before(){
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        //调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("pt()")
    public void after(){
        log.info("after ...");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing ...");
    }
}
