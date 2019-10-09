package com.atguigu.ribbonrule;


import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    IRule myRule(){
        return new RoundEp();
    }

}
