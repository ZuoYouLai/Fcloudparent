package com.samlai.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2019-04-11 15:25
 * @ Description：
 */
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class FeignHystrixConsumerTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixConsumerTwoApplication.class, args);
    }
}
