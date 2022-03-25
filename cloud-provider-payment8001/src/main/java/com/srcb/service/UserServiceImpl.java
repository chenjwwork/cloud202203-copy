package com.srcb.service;


import com.srcb.dao.UserMapper;
import com.srcb.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping("/queryById")
    public User queryById(Integer id) {
        System.out.println("当前调用的是provider1");
        return userMapper.queryById(id);
    }

    @Override
    @GetMapping(value = "/queryByUser")
    public User queryByUser(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userMapper.queryByUser(user);
    }


    @GetMapping(value = "/ggg")
    public User  queryByUser() {

        return userMapper.ggg();
    }


}
