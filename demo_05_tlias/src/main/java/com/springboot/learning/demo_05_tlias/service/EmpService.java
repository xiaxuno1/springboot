package com.springboot.learning.demo_05_tlias.service;

/*
* 员工管理接口
* */

import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {
    /**
    * 分页查询
    * */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
