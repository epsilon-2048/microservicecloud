package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller与ResponseBody的结合体
public class DeptController {

    @Autowired
    private DeptService deptService;

    //全局异常与服务熔断？
    //全局异常处理的是服务抛出的异常，而服务熔断处理的是服务宕机
    //服务降级是指资源紧张，暂时将某些非核心服务主动停掉，空出资源给核心服务，当资源不紧张时再启动非核心服务
    //所谓降级，一般是从整体负荷考虑，就是当某个服务熔断之后，服务器不再调用，
    //此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值。这样做，虽然服务水平下降，但好歹可用，比直接挂掉要强
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //服务监控好像基于HystrixCommand的，我在feign使用fallback图形化监控里无数据，显示loading
    @HystrixCommand(fallbackMethod = "processHystrix_Get")//这种方式会有两个问题1：方法膨胀，每个接口都会有对应的fallbackMethod，2这里其实是切面，将切面（processHystrix_Get）与业务逻辑整合在一起，导致高耦合
    public Dept get( @PathVariable("id") Long id){
        Dept dept = deptService.getDept(id);
        if (dept == null)
            throw new RuntimeException("error,没有此"+id);

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("error,没有此"+id);
    }
}
