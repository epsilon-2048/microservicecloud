package com.atguigu.springcloud.cfgbean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Configuration
public class ConfigBean {

    //类似RedisTemplate，提供了多种边界访问远程http服务的方法
    //是一种简单便捷的访问restful服务模板类，是spring提供的用于访问Rest服务的客户端模板工具类
    //关于RestTemplate可参考：https://blog.csdn.net/itguangit/article/details/78825505

    /**
     *  简单使用
     *  （url,requsetMap,ResponseBean,class）这三个参数
     *  分别代表Rest请求地址，请求参数，Http响应转换为想要的class对象类型
     *
     */

    @Bean
    @LoadBalanced  //Spring cloud ribbon 是基于netflix Ribbon实现的一套客户端 负载均衡的工具
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }


    //默认轮询选择算法，更改默认算法，为随机
   /* @Bean
    IRule myRule(){
        return new RandomRule();
    }*/

    //自定义选择算法 这是一种更改方式，还有一种是
    //在客户端启动类添加注解@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
    //他会在启动该微服务时去加载我们自定义的Ribbon配置类
    //但是第二种方式，自定义配置类不能放在@ComponentScan所扫描的当前包下及其子包下，
    //否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就说我们达不到特殊化定制的目的了
    //而启动类的注解@SpringBootApplication中带有ComponentScan注解，也就是说自定义配置类不能放在
    //com.atguigu.springcloud包下以及其子包下。
     /*@Bean
    IRule myRule(){
        return new MyRule();
    }*/
}

