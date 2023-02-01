package com.atguigu.controller;

import com.atguigu.entity.Employee;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Description: <br/>
 * date: 2022/12/26$ 19:03$<br/>
 *
 * @author: lanjiwei <br/>
 */

/**
 * 查询所有员工-->/employee-->get
 * 查询所有员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工-->/employee-->post
 * 修改员工-->/employee-->put
 * 删除员工-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        List<Employee> list = employeeService.getAllEmployee();
//      将员工信息在请求域中共享
        model.addAttribute("list",list);
//        跳转到employee_list.html
        return "employee_list";
    }

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享在请求域中
        model.addAttribute("page",page);
        return "employee_list";
    }
}
