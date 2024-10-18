package com.springboot.learning.demo_03_mybaits_crud_quickstart;

import com.springboot.learning.demo_03_mybaits_crud_quickstart.mapper.UserMapper;
import com.springboot.learning.demo_03_mybaits_crud_quickstart.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@SpringBootTest//springboot整合单元测试注解
class Demo03MybaitsCrudQuickstartApplicationTests {

	@Autowired  //mybaits的依赖注入
	private UserMapper userMapper;
	@Test
	public void testselectAll(){
		List<User> users =userMapper.selectAll(); //调用该接口实现类对象（代理对象）的方法
		users.forEach(System.out::println);
	}
}
