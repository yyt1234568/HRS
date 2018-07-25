package com.example.demo.service.impl;

import com.example.demo.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Recruit;
import com.example.demo.dao.RecruitDao;

@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public int insert(Recruit recruit){
        return recruitDao.insert(recruit);
    }
    @Override
    public void delete(int id){
        recruitDao.delete(id);
    }

    @Override
    public Recruit findById(Integer id) {
        return recruitDao.findById(id);
    }

    @Override
    public List<Recruit> findAll(){
        return recruitDao.findAll();
    }
    @Override
    public int update(Recruit recruit){
        return recruitDao.update(recruit);
    }

}
