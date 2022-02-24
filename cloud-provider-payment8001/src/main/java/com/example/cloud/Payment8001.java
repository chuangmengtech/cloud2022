package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 15:33
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class, args);
    }


}
