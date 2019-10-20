package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("error, 没有此"+id+",Consumer客户端提供的降级信息，此刻服务provider已经关闭");
            }

            @Override
            public List<Dept> deptList() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
