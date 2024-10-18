package com.springboot.learning.demo_04_springboot_mybatis_crud;

import com.springboot.learning.demo_04_springboot_mybatis_crud.Mapper.EmpMapper;
import com.springboot.learning.demo_04_springboot_mybatis_crud.Mapper.UserMapper;
import com.springboot.learning.demo_04_springboot_mybatis_crud.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo04SpringbootMybatisCrudApplicationTests {
    @Autowired  //依赖注入
    private EmpMapper empMapper;
    @Test
    public void testselectById(){
        Emp emp = empMapper.selectById(1);
        System.out.println(emp);
//        Emp(id=1, username=jinyong, password=123456, name=金庸, gender=1, image=1.jpg, job=4, entrydate=2000-01-01,
//                deptId=2, createTime=2024-08-21T09:55:23, updateTime=2024-08-21T09:55:23)

    }

}
