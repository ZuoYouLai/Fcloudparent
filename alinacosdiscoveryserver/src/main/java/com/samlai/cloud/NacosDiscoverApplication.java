package com.samlai.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-16 14:55
 * @ Description：
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosDiscoverApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoverApplication.class, args);
    }
}
