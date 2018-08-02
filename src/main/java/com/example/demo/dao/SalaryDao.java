package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Salary;

public interface SalaryDao {

    int insert( Salary pojo);

    int delete( int id);

    List<Salary> findAll();

    Salary findById(int id);

    int update( Salary pojo);

    Salary findByEmployeeId(int id);
}
