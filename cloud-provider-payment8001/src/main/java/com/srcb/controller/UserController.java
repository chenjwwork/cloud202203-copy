package com.srcb.controller;


import com.srcb.dao.UserMapper;
import com.srcb.entities.User;
import com.srcb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The company is 鉴真防务
 * User: 陳佳伟
 * Date: 2022/3/18 下午11:24
 * Description: 多敲多练
 **/
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/queryById")
    public User queryById(@RequestParam("id") Integer id) throws InterruptedException {
        //Thread.currentThread().sleep(5000);
        System.out.println("调用provider-8010-queryById");
        return userMapper.queryById(id);
    }

    @GetMapping("/queryByUser")
    public User queryByUser( )   {
        User user = new User();
        System.out.println("调用provider-8010-queryByUser");
        user.setUsername("lisi");
        user.setPassword("654321");
        return userService.queryByUser(user);
    }
}
