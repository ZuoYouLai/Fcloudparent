package com.samlai.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 16:12
 * @ Description：
 */
@RestController
@Slf4j
public class WebClientController {


    /**
     * 需要引入 ：
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-webflux</artifactId>
     </dependency>
     */
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @GetMapping("/rest/test")
//    public String test(String name) {
//        if (Objects.isNull(name)) {
//            name = "smalai";
//        }
//        String url = "http://ali-nacos-discovery-server/hello?name=" + name;
//        Mono<String> result = webClientBuilder.build()
//                .get()
//                .uri("http://alibaba-nacos-discovery-server/hello?name=didi")
//                .retrieve()
//                .bodyToMono(String.class);
//        return result;
//    }
//
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder loadBalancedWebClientBuilder() {
//        return WebClient.builder();
//    }



}
