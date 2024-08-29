package com.springboot.learning.demo_05_tlias.service.impl;

import com.springboot.learning.demo_05_tlias.mapper.EmpMapper;
import com.springboot.learning.demo_05_tlias.pojo.Emp;
import com.springboot.learning.demo_05_tlias.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp login(Emp emp) {
        return empMapper.selectByUsernameAndPassword(emp);
    }
}
