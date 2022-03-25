package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午8:40
 * Description: 多敲多练
 **/
@SpringBootApplication
@EnableEurekaClient//只能注册到eruake注册中心
@EnableDiscoveryClient//其他注册中心也可以
public class PayMentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8001.class,args);
    }
}
