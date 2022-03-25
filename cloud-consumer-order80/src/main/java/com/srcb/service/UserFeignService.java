package com.srcb.service;


import com.srcb.entities.User;
import com.srcb.fallback.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
@Service
@FeignClient(name = "cloud-payment-server",fallback = UserFallBack.class)
public interface UserFeignService {
    @GetMapping(value = "/queryById")
    public User queryById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/queryByUser",method = RequestMethod.POST)
    public User queryByUser(@RequestBody User user);


}