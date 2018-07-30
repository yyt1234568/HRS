package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Sign;

public interface SignDao {
    


    int update(@Param("sign") Sign sign);

    int delete(int id);

    List<Sign> findAll();

    int insertStart(Sign sign);

    int insertEnd(Sign sign);

    Sign findByUserAndDate(int id);

    List<Sign> findByUser(int id);
}
