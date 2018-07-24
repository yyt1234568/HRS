package com.example.demo.service;

import com.example.demo.entity.Resume;

public interface ResumeService {
    void insert(Resume resume);

    Resume findByUserId(Integer id);

    void update(Resume resume);
}
