package com.atguigu.mybatisplus.controller;


import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljw
 * @since 2023-01-05
 */
@RestController
@RequestMapping("/mybatisplus/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public User getUser(){
        User user = userService.getUser();
        return user;
    }

    @GetMapping("/list")
    public List<User> userList(){
        List<User> users = userService.userList();
        return users;
    }



}
