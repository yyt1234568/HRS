package com.example.demo.service.impl;

import com.example.demo.entity.Train;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.dao.TrainDao;

@Service("trainService")
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;
    @Override
    public int insert(Train train){
        return trainDao.insert(train);
    }

    @Override
    public int delete(int id){
        return trainDao.delete(id);
    }

    @Override
    public List<Train> findAll(){
        return trainDao.findAll();
    }

    @Override
    public int update(Train train){
        return trainDao.update(train);
    }

    @Override
    public Train findById(int id) {
        return trainDao.findById(id);
    }

}
