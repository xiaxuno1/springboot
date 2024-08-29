package com.springboot.learning.demo_05_tlias.controller;

import com.springboot.learning.demo_05_tlias.pojo.Dept;
import com.springboot.learning.demo_05_tlias.service.DeptService;
import com.springboot.learning.demo_05_tlias.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;
    //    员工列表查询 get方法  请求不传，则为默认值
    @GetMapping
//    public Result selectPage(@RequestParam(defaultValue = "1") Integer page,
//                             @RequestParam(defaultValue = "100") Integer pageSize,
//                             String name, Short gender,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        //形参定义与前端相同的字段，可以直接获取
//        //调用servic层处理数据，并返回
//        PageBean pageBean = deptService.page(page,pageSize,name,gender,begin,end);
//        //响应数据
//        return Result.success(pageBean);
//    }
    //无参数传递
    public Result selectAll(){
        List< Dept > depts = deptService.selectAll();
        return Result.success(depts);

    }
    @DeleteMapping("/{ids}") //路径参数的传递方式 @PathVariable
    public Result delete (@PathVariable Integer ids ) throws Exception{
        log.info("删除操作事务, id:{}",ids);
        deptService.delete(ids);
        return Result.success();
    }
    @PostMapping
//    @RequestBody 注解告诉 Spring MVC 从 HTTP 请求的正文中读取数据，
//    并将其转换为 Java 对象。它将请求正文中的数据（通常是 JSON 格式）自动转换成你指定的 Java 类型对象。
    public Result save(@RequestBody Dept dept){
        log.info("新增部门, dept: {}", dept);
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询部门信息, id: {}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //@RequestBody将请求体JSON、xml解析为java对象
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门信息 : {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
