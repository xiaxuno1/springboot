package com.springboot.learning.controller;

import com.springboot.learning.pojo.User;
import com.springboot.learning.pojo.User2;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
* 获取请求参数controller
* */
@RestController
public class RequestController {

    //采用原始方式获取，HttpServletRequest 获取 ；简单参数
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        String idStr = request.getParameter("id"); //getParameter获取参数key，大小写一致
//        String name = request.getParameter("name");
//
//        int id = Integer.parseInt(idStr); //获取的数字字符串转换为数字
//        System.out.println(idStr+" : "+name); //控制台输出
//        return "OK"; //返回给浏览器
//    }
    //采用Springboot方式获取，定义同名的形参即可接收参数获取 ；简单参数
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String id,String name){
//        System.out.println(id+" : "+name); //控制台输出
//        return "OK"; //返回给浏览器
//    }
    //请求参数名与实体类的属性名相同**；简单实体类参数
//    @RequestMapping("/simpleParam")
//    public String simpleParam(User user){
//        String idStr = user.getId();
//        String name =user.getName();
//        System.out.println(user); //实现了toSsring()。因此直接打印也可以看出来
//        int id = Integer.parseInt(idStr); //获取的数字字符串转换为数字
//        System.out.println(id+" : "+name); //控制台输出
//        return "OK"; //返回给浏览器
//    }

    //请求参数名与实体类的属性名相同**；复杂实体类参数
    //请求参数名与形参对象属性名相同，按照对象层次结构关系即可接收嵌套实体类属性参数。
//    @RequestMapping("/simpleParam")
//    public String simpleParam(User2 user){
//        System.out.println(user); //实现了toSsring()。因此直接打印也可以看出来
//        return "OK"; //返回给浏览器
//    }
    //数组参数
//    @RequestMapping("/listParam")
//    public String simpleParam(String[] hobby){
//        System.out.println(hobby);  //返回为对象[Ljava.lang.String;@24687878
//        System.out.println(Arrays.toString(hobby));//调用toString [games, football]
//        return "OK";
//    }

    //集合默认情况下，请求中参数名相同的多个值，是封装到数组。如果要封装到集合，要使用@RequestParam绑定参数关系
    @RequestMapping("/listParam")
    public String simpleParam(@RequestParam List<String> hobby){
        System.out.println(hobby);  //返回为对象[Ljava.lang.String;@24687878
        return "OK";
    }

    //@DateTimeFormat注解，以及其pattern属性来设置日期的格式。参数名称必须一致，否则会返回null
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        System.out.println(updateTime);  //返回为对象[Ljava.lang.String;@24687878
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User2 user){
        System.out.println(user);
        return "OK";
    }

    //路径参数 http://localhost:8080/user/1
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }
}
