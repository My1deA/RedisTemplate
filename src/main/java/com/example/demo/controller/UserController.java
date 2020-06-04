package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String  addUser(User user){
        userService.addUser(user);
        return "add user success";
    }

    @DeleteMapping("/del/{id}")
    public String delUserById(@PathVariable("id") Integer id){
        userService.delUserById(id);
        return "del user success";
    }

    @GetMapping("/get/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        User user=userService.findUserById(id);
        return user;
    }

    @GetMapping("/get")
    User findUserByUsername(@RequestParam("username") String username){
        User user=userService.findUserByUsername(username);
        return user;
    }

    @PutMapping("/save")
    public String  saveUser(User user){
        userService.saveUser(user);
        return "save user success";
    }

}
