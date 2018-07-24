package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean login(User user);

    boolean regist(User user);

    User findByName(String username);

    User findById(Integer id);
}
