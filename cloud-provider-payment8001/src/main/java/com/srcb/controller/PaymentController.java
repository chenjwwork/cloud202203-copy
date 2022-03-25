package com.srcb.controller;


import com.srcb.entities.CommonResult;
import com.srcb.entities.Payment;
import com.srcb.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/12 下午9:56
 * Description: 多敲多练
 **/

@RestController
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add( @RequestBody Payment payment){
        int result =  paymentService.add(payment);
        logger.info("调用了add方法8001");
        if(result>0){
            return new CommonResult(200,"插入数据成功"+serverPort,result);
        }
        return new CommonResult(444,"插入数据库失败"+serverPort,null);
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        logger.info("调用了getPaymentById方法8002");
        Payment payment =  paymentService.getPaymentById(id);
        //log.info();
        if(payment!=null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }
        return new CommonResult(444,"没有对应记录，查询ID："+id+serverPort,null);
    }

    @GetMapping("/payment/discovery")
    public Object discover(){

        //第一种得到服务清单列表
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            logger.info("*******element+"+element);
        }

        //根据微服务具体名称
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            logger.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+
                    "\t"+instance.getUri());
        }

        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/discoverys")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            logger.info("***** element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            logger.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @RequestMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
    @RequestMapping("/feign")
    public String getPaymentFeign()   {
        return serverPort;
    }

    @RequestMapping("/payment/zipkin")
    public String getPaymentZipkin()   {
        return "hi i'am paymentzipkin server fall back ";
    }



}
