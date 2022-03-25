package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;


/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/25 下午10:54
 * Description: 多敲多练
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinMain9411 {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinMain9411.class,args);
    }
}
