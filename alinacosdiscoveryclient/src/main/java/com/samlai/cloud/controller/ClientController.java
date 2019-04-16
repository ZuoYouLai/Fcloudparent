package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 15:37
 * @ Description：
 */
@RestController
@Slf4j
public class ClientController {


    //类似ribbion 负载均衡
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(String name) {
        if (Objects.isNull(name)) {
            name = "smalai";
        }
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("ali-nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + "     , return :    " + result;
    }



}
