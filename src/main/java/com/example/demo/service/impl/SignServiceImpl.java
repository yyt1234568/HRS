package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Sign;
import com.example.demo.dao.SignDao;

@Service("signService")
public class SignServiceImpl implements SignService {

    @Autowired
    private SignDao signDao;



    @Override
    public int insertStart(Sign sign) {
        return signDao.insertStart(sign);
    }

    @Override
    public int insertEnd(Sign sign) {
        return signDao.insertEnd(sign);
    }

    @Override
    public int delete(int id){
        return signDao.delete(id);
    }

    @Override
    public List<Sign> findAll(){
        return signDao.findAll();
    }
    @Override
    public int update(Sign sign){
        return signDao.update(sign);
    }

    @Override
    public List<Sign> findByUser(User user) {
        return signDao.findByUser(user.getId());
    }

    @Override
    public Sign findByUserAndDate(User user) {
        return signDao.findByUserAndDate(user.getId());
    }

    @Override
    public List<Sign> findSalary() {
        return signDao.findSalary();
    }

}
