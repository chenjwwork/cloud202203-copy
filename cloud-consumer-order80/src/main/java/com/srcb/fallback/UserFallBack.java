package com.srcb.fallback;


import com.srcb.entities.User;
import com.srcb.service.UserFeignService;
import org.springframework.stereotype.Component;


//降级
@Component
public class UserFallBack implements UserFeignService {
    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("ById服务器发生异常暂时以游客身份登录");
        return user;
    }

    @Override
    public User queryByUser(User user) {
        User user1=new User();
        user1.setUsername("ByUser服务器发生异常暂时以游客身份登录");
        return user1;
    }

}
