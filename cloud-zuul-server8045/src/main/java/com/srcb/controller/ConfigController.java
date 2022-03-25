package com.srcb.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

//    @Value("${token}")
//    private String token;
//
//    @RequestMapping(value = "/getConfig")
//    public String getConfig(){
//        System.out.println(token);
//        return token;
//    }
}
