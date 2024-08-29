package com.springboot.learning.demo_05_tlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//这里的aop配置没有生效，猜测是其他configuration冲突了，暂时不知道如何解决
@Slf4j
@Aspect //注解为AOP类才会生效
@Component //注册为springboot的bean才会被识别
public class TimeAspect {
    @Around("execution(* com.springboot.learning.demo_05_tlias.*.*(..))")
//    com.springboot.learning.demo_05_tlias 包下的所有类的所有方法
    public Object recordTime(ProceedingJoinPoint pjp) throws  Throwable {
        long begin = System.currentTimeMillis();//记录方法执行开始时间
        Object result = pjp.proceed();//执行原始方法
        long end = System.currentTimeMillis(); //记录方法执行结束时间

        log.info(pjp.getSignature()+"执行耗时: {}毫秒",end-begin);//计算方法执行耗时
        return result; //返回原始方法
    }
}
