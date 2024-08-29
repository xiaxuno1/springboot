package com.springboot.learning.demo_05_tlias.service.impl;

import com.springboot.learning.demo_05_tlias.mapper.DeptLogMapper;
import com.springboot.learning.demo_05_tlias.pojo.DeptLog;
import com.springboot.learning.demo_05_tlias.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)//需要新事务，无论有无，总是创建新事务
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
