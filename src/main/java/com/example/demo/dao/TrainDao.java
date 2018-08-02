package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Train;

public interface TrainDao {

    int insert(Train train);

    int update( Train train);

    List<Train> findAll();

    int delete(int id);

    Train findById(int id);
}
