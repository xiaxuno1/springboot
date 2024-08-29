package com.springboot.learning.demo_05_tlias.controller;

import com.springboot.learning.demo_05_tlias.mapper.EmpMapper;
import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.pojo.PageBean;
import com.springboot.learning.demo_05_tlias.service.EmpService;
import com.springboot.learning.demo_05_tlias.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    //mybatis依赖注入
    @Autowired
    private EmpService empService;
    //控制层体现

    //    员工列表查询 get方法  请求不传，则为默认值
    @GetMapping
    public Result selectPage(@RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             String name, Short gender,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //形参定义与前端相同的字段，可以直接获取
        //调用servic层处理数据，并返回
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        //响应数据
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}") //路径参数的传递方式 @PathVariable
    public Result delete(@PathVariable List<Integer> ids ){
        log.info("批量删除操作, ids:{}",ids);
        empService.delete(ids);
       return Result.success();
    }
    @PostMapping
//    @RequestBody 注解告诉 Spring MVC 从 HTTP 请求的正文中读取数据，
//    并将其转换为 Java 对象。它将请求正文中的数据（通常是 JSON 格式）自动转换成你指定的 Java 类型对象。
    public Result save(@RequestBody Emp emp ){
        log.info("新增员工, emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }
//@RequestBody将请求体JSON、xml解析为java对象
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息 : {}", emp);
        if (emp.getEntrydate() != null) {
            Class<?> entrydateType = emp.getEntrydate().getClass();
            log.info("entrydate 数据类型: {}", entrydateType.getName());
        } else {
            log.info("entrydate 是 null");
        }
        empService.update(emp);
        return Result.success();
    }


}
