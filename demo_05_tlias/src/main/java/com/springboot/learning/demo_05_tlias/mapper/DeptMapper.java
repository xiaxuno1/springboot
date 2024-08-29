package com.springboot.learning.demo_05_tlias.mapper;


import com.springboot.learning.demo_05_tlias.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DeptMapper {

    //    部门列表查询 支持分页查询
    public List<Dept> selectAll();
    //    部门列表查询 支持分页查询  limit 0,20  从0开始每页显示20行
    List<Dept> selectPage(String name, Short gender, LocalDate begin, LocalDate end);
    //    删除部门
    public void deleteById(Integer id);
    //批量删除 传入数组 List<Integer> 和 Integer[] 是两种不同的集合类型，分别代表了列表和数组
//    多参数数默认参数为arg0 arg1 param1 param2，@Param注解即可
//    @Param指定了参数名称为ids，这样可以在xml文件中collection="ids"使用
    void deleteByIds(@Param("ids")List<Integer> ids);

    //    添加部门
    public void insertByName(Dept dept);
    //     根据ID查询
    public Dept selectByID(Integer id);
    //    修改部门 有非必须字段，即可以传也可以不传，因此需要动态sql
    public void updateById(Dept dept);
}
