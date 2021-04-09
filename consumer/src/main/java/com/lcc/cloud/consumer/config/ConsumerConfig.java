package com.lcc.cloud.consumer.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Cong-Cong Liao
 * @since 2021-04-09
 **/
@Configuration
public class ConsumerConfig {
    // 将RestTemplate注入到IOC
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
