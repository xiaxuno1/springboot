package com.springboot.learning.demo_05_tlias.service;

import com.springboot.learning.demo_05_tlias.pojo.Emp;

public interface LoginService {
    /**
     * 员工登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
