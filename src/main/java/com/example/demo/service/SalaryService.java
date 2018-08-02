package com.example.demo.service;

import com.example.demo.entity.Salary;

import java.util.List;

public interface SalaryService {
    public int insert(Salary salary);

    public int delete(int id);

    public List<Salary> findAll();

    public Salary findById(int id);

    public int update(Salary salary);

    Salary findByEmployeeId(int id);
}
