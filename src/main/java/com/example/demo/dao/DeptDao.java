package com.example.demo.dao;

import java.util.List;
import com.example.demo.entity.Dept;

public interface DeptDao {

    int insert( Dept dept);

    void delete(int id);

    List<Dept> findAll();

    Dept findById(Integer id);

    int update( Dept dept);

}
