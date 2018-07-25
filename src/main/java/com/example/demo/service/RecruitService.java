package com.example.demo.service;

import com.example.demo.entity.Recruit;

import java.util.List;

public interface RecruitService {
    int insert(Recruit recruit);
    int update(Recruit recruit);
    List<Recruit> findAll();
    void delete(int id);

    Recruit findById(Integer id);
}
