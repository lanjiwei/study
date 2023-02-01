package com.atguigu.service;

import com.atguigu.entity.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description: <br/>
 * date: 2022/12/27$ 9:05$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface EmployeeService {
    /**
     * 获取员工的所有信息
     * @return
     */
     List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
