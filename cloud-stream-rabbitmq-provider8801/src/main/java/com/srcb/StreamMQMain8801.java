package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/24 下午9:11
 * Description: 多敲多练
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class,args);
    }
}
