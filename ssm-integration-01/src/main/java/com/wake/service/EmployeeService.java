package com.wake.service;

import com.wake.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询显示所有员工信息
     * @return
     */
    List<Employee> queryAll();
}
