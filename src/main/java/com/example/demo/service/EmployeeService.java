package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    int insert(Employee employee);


    int delete(int id);


    List<Employee> findAll();


    int update(Employee employee);

    Employee findByName(String username);
}
