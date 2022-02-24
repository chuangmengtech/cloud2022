package com.example.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sun
 * @version 1.0
 * @date 2022/1/13 23:41
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
