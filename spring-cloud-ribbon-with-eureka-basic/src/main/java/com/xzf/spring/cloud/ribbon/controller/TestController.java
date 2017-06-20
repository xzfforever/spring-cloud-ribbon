package com.xzf.spring.cloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/user/{id}")
    public String getUserInfo1(@PathVariable String id){
        //调用方式为：http://serviceName/...;其中serviceName为Eureka上注册的应用名（Application Name）
        String url = String.format("http://%s/user/%s","USER-CENTER",id);
        return restTemplate.getForObject(url,String.class);
    }
}
