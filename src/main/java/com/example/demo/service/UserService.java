package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    void addUser(User user);
    void delUserById(Integer id);
    User getUserById(Integer id);
    User getUserByUsername(String username);
    void saveUser(User user);
}
