package com.example.cloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/8 21:51
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用@LoadBalanced注解赋予了restTemplate负载均衡的能力
     *
     * @return @RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
