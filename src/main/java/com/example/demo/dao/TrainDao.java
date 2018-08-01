package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Train;

public interface TrainDao {

    int insert(@Param("train") Train train);

    int update(@Param("train") Train train);

    List<Train> findAll();

    int delete(int id);

    Train findById(int id);
}
