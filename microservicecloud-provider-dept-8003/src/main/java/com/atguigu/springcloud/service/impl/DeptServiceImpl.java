package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.mapper.DeptMapper;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept getDept(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> DeptList() {
        return deptMapper.findAll();
    }
}
