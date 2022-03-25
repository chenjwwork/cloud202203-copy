package com.srcb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/17 上午12:36
 * Description: 多敲多练
 **/
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo()
    {
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);

    }
}
