package com.srcb.controller;

import com.srcb.entities.CommonResult;
import com.srcb.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午11:18
 * Description: 多敲多练
 **/
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> add(Payment payment){
        //return restTemplate.postForObject("http://localhost:8001"+"/payment/add",payment,CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{sid}")
    public CommonResult<Payment> getPaymentById(@PathVariable("sid") Long id){
        //return restTemplate.postForObject("http://localhost:8001"+"/payment/add",payment,CommonResult.class);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }




}
