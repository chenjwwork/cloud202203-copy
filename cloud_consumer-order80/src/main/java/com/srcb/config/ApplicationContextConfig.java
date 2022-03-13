package com.srcb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午11:31
 * Description: 多敲多练
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
