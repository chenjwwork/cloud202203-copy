package com.srcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient//注册到服务中心
@EnableZuulProxy//声明Zuul代理默认已经使用Ribbon实现了负载均衡，
public class Zuul8045 {

	public static void main(String[] args) {
		SpringApplication.run(Zuul8045.class, args);
	}

}
