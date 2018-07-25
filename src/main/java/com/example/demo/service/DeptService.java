package com.example.demo.service;

import com.example.demo.entity.Dept;

import java.util.List;

public interface DeptService {
    int update(Dept dept);
    List<Dept> findAll();
    void delete(int id);
    int insert(Dept dept);
}
