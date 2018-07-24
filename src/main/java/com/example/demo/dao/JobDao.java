package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Job;

public interface JobDao {


    List<Job> findAll();
}
