package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Resume;

public interface ResumeDao {


    void insert(Resume resume);

    Resume findByUserId(Integer id);

    void update(Resume resume);
}
