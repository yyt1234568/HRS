package com.example.demo.service.impl;

import com.example.demo.dao.SignDao;
import com.example.demo.entity.Employee;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Sign;
import com.example.demo.entity.User;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SignDao signDao;

    @Override
    public int insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    @Override
    public int delete(int id) {
        return employeeDao.delete(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee findByName(String username) {
        return employeeDao.findByName(username);
    }

    @Override
    public List<Employee> findByDeptIdAndJobId(Integer dept_id, Integer job_id) {
        return employeeDao.findByDeptIdAndJobId(dept_id,job_id);
    }

    @Override
    public int isSameStartToday(User user, Date now) {

        Sign sign=signDao.findByUserAndDate(user.getId());

        if (sign!=null) {
            boolean flag=(DateUtils.isSameDay(now, sign.getStart_date()));
            return flag==true?1:0;
        }else{
            return 0;
        }
    }

    @Override
    public int isSameEndToday(User user, Date now, String start, String end) {

        Sign sign=signDao.findByUserAndDate(user.getId());

        if (sign!=null) {
            if(sign.getEnd_date()==null){
                return 0;
            }else{
                return 1;
            }

        }else{
            return 1;
        }
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void updateAll(Employee employee) {
        employeeDao.updateAll(employee);
    }

}
