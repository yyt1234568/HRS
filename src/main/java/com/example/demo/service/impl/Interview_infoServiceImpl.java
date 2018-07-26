package com.example.demo.service.impl;

import com.example.demo.entity.Interview_info;
import com.example.demo.service.Interview_infoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.example.demo.dao.Interview_infoDao;

@Service("interview_infoService")
public class Interview_infoServiceImpl implements Interview_infoService {

    @Resource
    private Interview_infoDao interview_infoDao;

    @Override
    public int insert(Interview_info pojo){
        return interview_infoDao.insert(pojo);
    }

    @Override
    public int delete(int id){
        return interview_infoDao.delete(id);
    }

    @Override
    public List<Interview_info> findAll(){
        return interview_infoDao.findAll();
    }
    @Override
    public int update(Interview_info pojo){
        return interview_infoDao.update(pojo);
    }

}
