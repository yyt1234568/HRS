package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Dept;

public interface DeptDao {

    int insert( Dept dept);

    void delete(int id);

    List<Dept> findAll();

    Dept findById();

    int update( Dept dept);

}
