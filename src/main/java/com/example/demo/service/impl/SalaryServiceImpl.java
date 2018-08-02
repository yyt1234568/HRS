package com.example.demo.service.impl;

import com.example.demo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Salary;
import com.example.demo.dao.SalaryDao;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Override
    public int insert(Salary salary){
        return salaryDao.insert(salary);
    }

    @Override
    public int delete(int id){
        return salaryDao.delete(id);
    }

    @Override
    public List<Salary> findAll(){
        return salaryDao.findAll();
    }

    @Override
    public Salary findById(int id) {
        return salaryDao.findById(id);
    }

    @Override
    public int update(Salary salary){
        return salaryDao.update(salary);
    }

    @Override
    public Salary findByEmployeeId(int id) {
        return salaryDao.findByEmployeeId(id);
    }

}
