package com.atguigu.mybatisplus.service;

import com.atguigu.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljw
 * @since 2023-01-05
 */
public interface UserService extends IService<User> {
    User getUser();

    List<User> userList();
}
