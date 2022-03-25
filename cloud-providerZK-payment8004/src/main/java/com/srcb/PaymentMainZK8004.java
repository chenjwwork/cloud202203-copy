package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/16 下午11:02
 * Description: 多敲多练
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainZK8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainZK8004.class,args);

    }

}
