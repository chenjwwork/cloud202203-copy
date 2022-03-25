package com.srcb.dao;


import com.srcb.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User queryById(@Param("id") Integer id);

    public User queryByUser(@Param("id") User user);
}
