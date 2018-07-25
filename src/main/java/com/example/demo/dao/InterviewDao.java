package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Interview;

public interface InterviewDao {

    int insert( Interview interview);

    int delete(int id);

    List<Interview> findAll();

    Interview findById(int id);

    int update( Interview interview);

}
