package com.samlai.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerAuthentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerAuthentApplication.class, args);
    }
}
