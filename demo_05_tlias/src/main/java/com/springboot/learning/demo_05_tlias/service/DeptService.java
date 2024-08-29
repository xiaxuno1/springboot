package com.springboot.learning.demo_05_tlias.service;

import com.springboot.learning.demo_05_tlias.pojo.Dept;
import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;


public interface DeptService {
    /**
     * 分页查询
     * */
    //PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 查询所有，无参
     * **/
    List<Dept> selectAll();
    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增部门
     * @param
     */
    void save(Dept dept);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Dept dept);

    /**
     * 删除部门，即部门下的所有员工
     * **/
    void delete(Integer id) throws Exception;

}
