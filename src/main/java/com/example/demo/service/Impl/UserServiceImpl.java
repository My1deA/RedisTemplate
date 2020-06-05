package com.example.demo.service.Impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.RedisService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUserById(Integer id) {
        userMapper.delUserById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        //目前redis无法设置 hashmap里面的hashkey的过期时间 也就是说 下面的代码只能实现一些类似验证码的过期处理
        // 但我目前用来处理登录验证密码
        User user=redisService.getUserByUsername(username);
        if(user != null){
            System.out.println("redis string get");
        }else{
            System.out.println("mysql string get");
            user=userMapper.getUserByUsername(username);
            redisService.addUser(user);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
}
