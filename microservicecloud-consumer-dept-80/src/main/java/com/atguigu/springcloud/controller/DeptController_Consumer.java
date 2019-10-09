package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//暴露给其他需要调动此服务的接口
@RestController
public class DeptController_Consumer {

    @Autowired
    private RestTemplate restTemplate;

   // private static final String REST_URL_PREFIX = "http://localhost:8001";//写死在这里?感觉怪怪的？应该后期使用feign服务实例
   private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";


    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get( @PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> deptList(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list" , List.class);
    }

    //eureka-服务发现

    @RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
