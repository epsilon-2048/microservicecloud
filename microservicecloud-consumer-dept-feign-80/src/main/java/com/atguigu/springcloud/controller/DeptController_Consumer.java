package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

//暴露给其他需要调动此服务的接口
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept){
        return service.add(dept);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get( @PathVariable("id") Long id){
        return service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> deptList(){
        return service.deptList();
    }

    //eureka-服务发现

    @RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        return service.discovery();
    }
}
