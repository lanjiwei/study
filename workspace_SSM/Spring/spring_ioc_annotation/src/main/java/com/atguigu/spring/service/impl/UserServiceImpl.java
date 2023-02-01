package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: <br/>
 * date: 2022/12/14$ 14:27$<br/>
 *
 * @author: lanjiwei <br/>
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
