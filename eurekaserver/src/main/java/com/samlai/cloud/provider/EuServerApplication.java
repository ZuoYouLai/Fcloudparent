package com.samlai.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-04 17:29
 * @ Description：
 */
@SpringBootApplication
@EnableEurekaServer
public class EuServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EuServerApplication.class, args);
    }
}
