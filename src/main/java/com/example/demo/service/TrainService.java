package com.example.demo.service;

import com.example.demo.entity.Train;

import java.util.List;

public interface TrainService {

    int insert(Train train);

    int delete(int id);

    List<Train> findAll();

    int update(Train train);

    Train findById(int id);
}
