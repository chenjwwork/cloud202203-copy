package com.srcb.dao;


import com.srcb.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public User queryById(@Param("cc") Integer cc);

    public User queryByUser(@Param("cc")User user);


    public User ggg();
}
