package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public int insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    @Override
    public int delete(int id) {
        return employeeDao.delete(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee findByName(String username) {
        return employeeDao.findByName(username);
    }

}
