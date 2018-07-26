package com.example.demo.service;

import com.example.demo.entity.Interview;

import java.util.List;

public interface InterviewService {


    int insert(Interview interview);

    void delete(int id);

    List<Interview> findAll();

    int update(Interview interview);

    Interview findById(Integer id);
}
