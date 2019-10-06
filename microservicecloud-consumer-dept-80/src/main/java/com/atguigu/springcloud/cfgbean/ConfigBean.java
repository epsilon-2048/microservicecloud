package com.atguigu.springcloud.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
