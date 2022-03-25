package com.srcb.service;

import com.srcb.entities.User;

public interface UserService {

    public User queryById(Integer id);

    public User queryByUser(User user);

}
