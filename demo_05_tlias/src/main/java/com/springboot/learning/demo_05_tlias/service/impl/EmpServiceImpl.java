package com.springboot.learning.demo_05_tlias.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.learning.demo_05_tlias.mapper.EmpMapper;
import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.pojo.PageBean;
import com.springboot.learning.demo_05_tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //spring IOC 注解是@Component的衍生注解标准在业务类上
public class EmpServiceImpl implements EmpService{

    @Autowired  //依赖注入；注入EmpMapper中的代理对象
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //采用pageHelper分页查询
        //查询前 设置分页参数
        PageHelper.startPage(page,pageSize);//设置分页的起始页和每页数据条数
        //执行条件分页查询
        List<Emp> empList = empMapper.selectPage( name,gender,begin,end);
        //查询后获取分页信息对象
        Page<Emp> p = (Page<Emp>) empList;
        System.out.println(p);
        //获取pageinfo信息(总数、当前页列表)组成新的pagebean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void save(Emp emp) {
        empMapper.insertByName(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.selectByID(id);
    }

    @Override
    public void update(Emp emp) {
        empMapper.updateById(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return null;
    }
}
