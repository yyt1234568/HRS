package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.demo.dao.UserDao;

@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insert(User pojo){
        return userDao.insert(pojo);
    }


    public List<User> select(User pojo){
        return userDao.select(pojo);
    }

    public int update(User pojo){
        return userDao.update(pojo);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
