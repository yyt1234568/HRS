package com.example.demo.service.impl;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.demo.dao.DeptDao;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public int insert(Dept dept){
        return deptDao.insert(dept);
    }

    @Override
    public void delete(int id){
        deptDao.delete(id);
    }

    @Override
    public List<Dept> findAll(){
        return deptDao.findAll();
    }

    @Override
    public int update(Dept dept){
        return deptDao.update(dept);
    }

}
