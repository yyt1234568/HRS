package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean login(User user) {
        User user1=userDao.findByUserName(user.getUsername());
        return (user1!=null&&user.getPassword().equals(user1.getPassword()));
    }

    @Override
    public boolean regist(User user) {
        return userDao.insert(user)==1?true:false;
    }

    @Override
    public User findByName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }
}
