package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    void addUser(User user);
    void delUserById(Integer id);
    User findUserById(Integer id);
    User findUserByUsername(String username);
    void saveUser(User user);
}
