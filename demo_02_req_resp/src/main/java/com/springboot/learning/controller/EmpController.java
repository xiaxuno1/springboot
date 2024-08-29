package com.springboot.learning.controller;

//响应emp案例

import com.springboot.learning.pojo.Emp;
import com.springboot.learning.pojo.Result;
import com.springboot.learning.utils.XmlParserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @RequestMapping("/listEmp")
    public Result listEmp(){
        //1.加载解析emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile(); //读取文件
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file,Emp.class); //解析，返回一个对象列表
        empList.stream().forEach(System.out::println);

        //2.数据处理，gender.job
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ( "1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }
            else emp.setGender("未知");
        String job = emp.getJob();
        if("1".equals(job)){
            emp.setJob("讲师");
        }else if("2".equals(job)){
            emp.setJob("班主任");
        }else if("3".equals(job)){
            emp.setJob("就业指导");
        }
        });
        //3.响应，对象组成的List
        return Result.success(empList);
    }
}
