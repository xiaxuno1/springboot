package com.springboot.learning.demo_04_springboot_mybatis_crud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private  String password;
    private String name;
    private Integer gender;
    private String image;
    private Integer job;
    private LocalDate entrydate;  //sql 中的date 年月日格式
    private Integer deptId; //SQL 中下划线，java中转换为驼峰，mybatis会自动转换
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
