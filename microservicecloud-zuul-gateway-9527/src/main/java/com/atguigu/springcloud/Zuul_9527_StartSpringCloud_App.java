package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
//zuul默认提供了服务与发现，断路器hystrix
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Zuul_9527_StartSpringCloud_App {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(Zuul_9527_StartSpringCloud_App.class,args);
    }
}
