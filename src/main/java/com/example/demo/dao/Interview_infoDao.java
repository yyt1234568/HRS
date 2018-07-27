package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Interview_info;

public interface Interview_infoDao {

    int insert(Interview_info interview_info);



    int update( Interview_info interview_info);

    int delete(int id);

    List<Interview_info> findAll();

    Interview_info findByInterviewId(int id);
}
