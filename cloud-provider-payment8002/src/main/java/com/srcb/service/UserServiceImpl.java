package com.srcb.service;



import com.srcb.dao.UserMapper;
import com.srcb.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping("/queryById")
    //@HystrixCommand(fallbackMethod = "hystrix")
    public User queryById(Integer id) {
        System.out.println("当前调用的是provider");
        User user = userMapper.queryById(id);
        if(null == user){
            throw new RuntimeException("fail");
        }
        return user;
    }

    //备选方法
    public User hystrix(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("没有对应的信息");
        user.setPassword("null");
        return user;
    }

    @Override
    @RequestMapping(value = "/queryByUser",method = RequestMethod.POST)
    public User queryByUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userMapper.queryByUser(user);
    }
}
