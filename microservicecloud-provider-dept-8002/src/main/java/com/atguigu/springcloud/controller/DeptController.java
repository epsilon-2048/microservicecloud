package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller与ResponseBody的结合体
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get( @PathVariable("id") Long id){
        System.out.println(8002);
        return deptService.getDept(id);
    }
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> deptList(){
        System.out.println("8002:controller层");
        return deptService.DeptList();
    }

    //eureka服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*********" + list);
        List<ServiceInstance> serviceInstances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance e :
                serviceInstances) {
            System.out.println(e.getServiceId() + "\t"
                    +  e.getHost() + "\t"
                    +  e.getPort() + "\t"
                    +  e.getUri() + "\t"
                    + e.isSecure());
        }
        return this.client;
    }
}
