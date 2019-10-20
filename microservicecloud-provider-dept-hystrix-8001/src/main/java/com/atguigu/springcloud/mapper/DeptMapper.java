package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 或者在启动类上添加MapperScan
public interface DeptMapper {

    boolean addDept(Dept dept);
    Dept findById(Long id);
    List<Dept> findAll();
}
