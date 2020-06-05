package com.example.demo.service.Impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

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
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        //目前redis无法设置 hashmap里面的hashkey的过期时间 也就是说 下面的代码只能实现一些类似验证码的过期处理
        // 但我目前用来处理登录验证密码
        User user=new User();
        if(redisTemplate.hasKey(username)){
            System.out.println("redis get");
            String password= (String) redisTemplate.opsForValue().get(username);
            user.setPassword(password);
            user.setUsername(username);
        }else{
            System.out.println("mapper get");
            user=userMapper.findUserByUsername(username);
            redisTemplate.opsForValue().set(user.getUsername(),user.getPassword());
            redisTemplate.expire(user.getUsername(),10, TimeUnit.SECONDS);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }
}
