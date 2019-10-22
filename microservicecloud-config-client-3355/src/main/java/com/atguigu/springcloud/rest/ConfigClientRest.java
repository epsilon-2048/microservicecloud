package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @Override
    public String toString() {
        return "ConfigClientRest{" +
                "applicationName='" + applicationName + '\'' +
                ", eurekaServers='" + eurekaServers + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

    @GetMapping("/config")
    public String getConfig(){
        return toString();
    }
}
