package com.atguigu.springcloud;

import com.atguigu.ribbonrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
//如果报80端口被占用，可能是启用了iis服务，
    //如何关闭：右键此电脑，选择管理选项，点击下拉服务和应用程序，
    // 点击iis管理器，在最右侧有启动、停止选项，然后停止
    //下次开机还是会自启动的。可以卸载
}
