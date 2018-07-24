package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.User;

public interface UserDao {


    List<User> findAll();

    User findByUserName(String username);

    int insert(User user);

    User findById(Integer id);
}
