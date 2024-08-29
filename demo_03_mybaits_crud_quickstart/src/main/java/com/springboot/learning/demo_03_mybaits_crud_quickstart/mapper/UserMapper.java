package com.springboot.learning.demo_03_mybaits_crud_quickstart.mapper;

import com.springboot.learning.demo_03_mybaits_crud_quickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
* mybatis的mapper,为Dao接口，实现crud
* */
@Mapper //在运行时,会自动生成该接口的实现类对象(代理对象), 并且将该对象交给IOC容器管理
public interface UserMapper {
    //查询全体，调用mybatis的注解
    @Select("select * from user;")
    public List<User> selectAll();
}
