package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午8:40
 * Description: 多敲多练
 **/
@SpringBootApplication
@EnableEurekaClient
public class PayMentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8001.class,args);
    }
}
