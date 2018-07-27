package com.example.demo.service;

import com.example.demo.entity.Interview_info;

import java.util.List;

public interface Interview_infoService {
    int insert(Interview_info interview_info);

    int delete(int id);

    List<Interview_info> findAll();

    int update(Interview_info interview_info);

    Interview_info findByInterviewId(int id);
}
