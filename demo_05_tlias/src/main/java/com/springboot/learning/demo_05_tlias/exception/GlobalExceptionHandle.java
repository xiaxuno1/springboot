package com.springboot.learning.demo_05_tlias.exception;

import com.springboot.learning.demo_05_tlias.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器，出错时处理@RestControllerAdvice = @ControllerAdvice + @ResponseBody
@RestControllerAdvice//加上这个注解就代表我们定义了一个全局异常处理器。处理异常的方法返回值会转换为json后再响应给前端
public class GlobalExceptionHandle {
//处理异常
    @ExceptionHandler(Exception.class) //指定异常处理类型
    public Result ex(Exception e){
        e.printStackTrace();//打印堆栈中的异常信息

        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
}
}
