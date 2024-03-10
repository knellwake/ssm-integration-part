package com.wake.mapper;

import com.wake.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 员工表CRUD
 */
public interface EmployeeMapper {
    /**
     * 查询全部员工信息
     * @return
     */
    List<Employee> queryList();
}