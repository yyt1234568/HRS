package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Recruit;

public interface RecruitDao {

    int insert(Recruit recruit);
    

    List<Recruit> findAll();

    Recruit findById(int id);

    int update(Recruit recruit);

    void delete(int id);

}
