package com.wake.controller;

import com.wake.pojo.Employee;
import com.wake.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("find")
    public List<Employee> find(){
        List<Employee> employeeList = employeeService.queryAll();
        System.out.println(employeeList);
        return employeeList;
    }
}