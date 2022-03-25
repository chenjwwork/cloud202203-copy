package com.srcb.controller;

import com.srcb.entities.CommonResult;
import com.srcb.entities.Payment;
//import com.srcb.lb.LoadBalancer;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午11:18
 * Description: 多敲多练
 **/
@RestController
@Slf4j
public class OrderController {
    //http调用
    //private static final String PAYMENT_URL="http://localhost:8001";
    //通过在eureka上注册过的微服务名称调用
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVER";

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
//    @Resource
//    private LoadBalancer loadBalancer;


    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> add(Payment payment){
        //return restTemplate.postForObject("http://localhost:8001"+"/payment/add",payment,CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/postForObject")
    public CommonResult<Payment> create(Payment payment){
         return restTemplate.postForEntity(PAYMENT_URL+"/payment/add",payment,CommonResult.class).getBody();
    }

    @GetMapping(value = "/consumer/payment/get/{sid}")
    public CommonResult<Payment> getPaymentById(@PathVariable("sid") Long id){
        //return restTemplate.postForObject("http://localhost:8001"+"/payment/add",payment,CommonResult.class);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getHeaders()+"\t"+entity.getStatusCode()+"\t"+entity.getBody());
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }


//    @GetMapping(value = "/consumer/payment/lb")
//    public String getPaymentLB()
//    {
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//
//        if(instances == null || instances.size() <= 0)
//        {
//            return null;
//        }
//
//        ServiceInstance serviceInstance = loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//
//        return restTemplate.getForObject(uri+"/payment/lb",String.class);
//
//    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }






}
