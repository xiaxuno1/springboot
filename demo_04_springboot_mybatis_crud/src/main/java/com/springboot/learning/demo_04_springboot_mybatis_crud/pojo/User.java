package com.springboot.learning.demo_04_springboot_mybatis_crud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Lombok实现编译时自动生成构造函数、setter、getter、equal
@AllArgsConstructor //全参构造
@NoArgsConstructor//空参构造
public class User {
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;

    }
