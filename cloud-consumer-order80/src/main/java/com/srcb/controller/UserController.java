package com.srcb.controller;


import com.srcb.entities.User;

import com.srcb.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private UserFeignService userFeignService;



    //获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/login")
    public User login(Integer id){
        User user1=null;
        for(int i=1;i<=10;i++){
         user1= userFeignService.queryById(1);
        }
        return user1;
    }


    @RequestMapping(value = "/userLogin")
    public User login(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userFeignService.queryByUser(user);
    }


    //注册进来的微服务  获得一些消息
    @GetMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println(services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("USER-CONSUMER");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+
                    instance.getServiceId()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri());
        }

        return client;
    }


}
