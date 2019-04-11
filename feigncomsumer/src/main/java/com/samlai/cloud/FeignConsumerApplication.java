package com.samlai.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-11 15:25
 * @ Description：
 */
@EnableFeignClients
@SpringBootApplication
public class FeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
