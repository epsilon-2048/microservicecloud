package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    boolean add(Dept dept);
    Dept getDept(Long id);
    List<Dept> DeptList();
}
