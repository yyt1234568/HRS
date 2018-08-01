package com.example.demo.service;

import com.example.demo.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    List<Job> findByDeptId(int dept_id);

    void delete(Integer id);

    Job findById(Integer id);

    void insert(Job job);

    void update(Job job);
}
