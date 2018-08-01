package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeDao {

    int insert(Employee employee);

    int delete( int id);

    List<Employee> findAll();

    int update( Employee employee);

    int updateAll( Employee employee);

    Employee findByName(String username);

    List<Employee> findByDeptIdAndJobId(@Param("dept_id") Integer dept_id, @Param("job_id") Integer job_id);

    Employee findById(int id);
}
