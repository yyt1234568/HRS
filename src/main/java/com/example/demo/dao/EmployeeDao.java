package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeDao {

    int insert(Employee employee);

    int delete( int id);

    List<Employee> findAll();

    int update( Employee employee);

    Employee findByName(String username);
}
