package com.wake.service.impl;

import com.wake.mapper.EmployeeMapper;
import com.wake.pojo.Employee;
import com.wake.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: service业务层实现
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryAll() {
        List<Employee> employeeList = employeeMapper.queryList();
        return employeeList;
    }
}