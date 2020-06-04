package com.example.demo.mapper;


import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    void addUser(User user);
    void delUserById(Integer id);
    User findUserById(Integer id);
    User findUserByUsername(String username);
    void saveUser(User user);
}
