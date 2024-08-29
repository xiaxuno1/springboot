package com.springboot.learning.demo_05_tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.learning.demo_05_tlias.mapper.DeptLogMapper;
import com.springboot.learning.demo_05_tlias.mapper.DeptMapper;
import com.springboot.learning.demo_05_tlias.mapper.EmpMapper;
import com.springboot.learning.demo_05_tlias.pojo.Dept;
import com.springboot.learning.demo_05_tlias.pojo.DeptLog;
import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.pojo.PageBean;
import com.springboot.learning.demo_05_tlias.service.DeptLogService;
import com.springboot.learning.demo_05_tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service //spring IOC 注解是@Component的衍生注解标准
public class DeptServiceImpl implements DeptService {

    @Autowired //有效范围只单个属性
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

//    @Override
//    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//        //采用pageHelper分页查询
//        //查询前 设置分页参数
//        //部门没有分页，请求不会传，但是在Controller层设置了默认传递，因此可以不处理
//        PageHelper.startPage(page,pageSize);//设置分页的起始页和每页数据条数
//        //执行条件分页查询
//        List<Emp> empList = deptMapper.selectPage( name,gender,begin,end);
//        //查询后获取分页信息对象
//        Page<Emp> p = (Page<Emp>) empList;
//        System.out.println(p);
//        //获取pageinfo信息(总数、当前页列表)组成新的pagebean
//        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//        return pageBean;
//    }


    @Override
    public List<Dept> selectAll() {
        return   deptMapper.selectAll();

    }

    @Override
    public void delete(List<Integer> ids) {
        deptMapper.deleteByIds(ids);
    }

    @Override
    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insertByName(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectByID(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now()); //设置更新时间
        deptMapper.updateById(dept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//当前方法添加事务管理，异常会自动回滚，但是只有出现RuntimeException(运行时异常)才会回滚事务
//    rollbackFor设定异常回滚的条件
    public void delete(Integer id) throws Exception{
        //根据部门id删除部门信息
        try {
            //根据部门id删除部门信息
            deptMapper.deleteById(id);
            //模拟：异常
            if(true){
                throw new Exception("出现异常了~~~");
            }
            //删除部门下的所有员工信息
            empMapper.deleteByDeptId(id);
        }finally {
            //不论是否有异常，最终都要执行的代码：记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是"+id+"号部门");
            //调用其他业务类中的方法，虽然finally会使此永远呗执行，但是调用另一个方法时基于事务的传递性，
            // @Transactional注解当中的第二个属性propagation 默认会有则加入，无则创建新事务；这里有事务了会加入，
            // 因此insert(deptLog)也会被回滚，因此要开启新事务
            deptLogService.insert(deptLog);
        }


    }
}
