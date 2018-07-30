package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    int insert(Employee employee);


    int delete(int id);


    List<Employee> findAll();


    int update(Employee employee);

    Employee findByName(String username);

    List<Employee> findByDeptIdAndJobId(Integer dept_id, Integer job_id);

    int isSameStartToday(User user, Date now);
    int isSameEndToday(User user, Date now, String start, String end);
}
