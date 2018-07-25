package com.example.demo.service.impl;

import com.example.demo.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Interview;
import com.example.demo.dao.InterviewDao;

@Service("interviewService")
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewDao interviewDao;

    @Override
    public int insert(Interview interview){
        return interviewDao.insert(interview);
    }

    @Override
    public void delete(int id){
        interviewDao.delete(id);
    }

    @Override
    public List<Interview> findAll(){
        return interviewDao.findAll();
    }

    @Override
    public int update(Interview interview){
        return interviewDao.update(interview);
    }

}
