package com.example.demo.service.impl;

import com.example.demo.entity.Resume;
import com.example.demo.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.demo.dao.ResumeDao;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;


    @Override
    public void insert(Resume resume) {
        resumeDao.insert(resume);
    }

    @Override
    public Resume findByUserId(Integer id) {
        return resumeDao.findByUserId(id);
    }

    @Override
    public void update(Resume resume) {
        resumeDao.update(resume);
    }

    @Override
    public Resume findById(Integer id) {
        return resumeDao.findById(id);
    }
}
