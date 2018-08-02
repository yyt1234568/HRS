package com.example.demo.service;

import com.example.demo.entity.Sign;
import com.example.demo.entity.User;

import java.util.List;

public interface SignService {
    int insertStart(Sign sign);

    int insertEnd(Sign sign);

    int delete(int id);

    List<Sign> findAll();

    int update(Sign sign);

    List<Sign> findByUser(User user);

    Sign findByUserAndDate(User user);

    List<Sign> findSalary();
}
