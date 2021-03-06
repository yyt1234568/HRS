package com.example.demo.service.impl;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.demo.dao.JobDao;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;


    @Override
    public List<Job> findAll() {
        return jobDao.findAll();
    }

    @Override
    public List<Job> findByDeptId(int dept_id) {
        return jobDao.findByDeptId(dept_id);
    }

    @Override
    public void delete(Integer id) {
        jobDao.delete(id);
    }

    @Override
    public Job findById(Integer id) {
        return jobDao.findById(id);
    }

    @Override
    public void insert(Job job) {
        jobDao.insert(job);
    }

    @Override
    public void update(Job job) {
        jobDao.update(job);
    }
}
