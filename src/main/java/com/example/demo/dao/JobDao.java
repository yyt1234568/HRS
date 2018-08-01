package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Job;

public interface JobDao {



    void delete(int id);

    List<Job> findAll();

    Job findById(int id);

    List<Job> findByDeptId(int dept_id);

    void update(Job job);

    void insert(Job job);
}
