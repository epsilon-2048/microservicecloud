package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
//不加，会报Cannot determine embedded database driver class for database type NONE error.
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class DeptConsumer_DashBoard_App {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(DeptConsumer_DashBoard_App.class,args);
    }

}
