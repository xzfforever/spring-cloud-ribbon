package com.xzf.spring.cloud.ribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @GetMapping(value ="/user/{id}")
    public String getUserInfo(@PathVariable(value = "id") String userId){
        ServiceInstance choosedService = loadBalancerClient.choose("user-service-provider");
        String url = choosedService.getUri()+"/user/" + userId;
        System.out.println("----choosed server info------"+url);
        return this.restTemplate.getForObject(url,String.class);
    }





}
