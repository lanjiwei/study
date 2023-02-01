package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Description: <br/>
 * date: 2022/12/14$ 14:28$<br/>
 *
 * @author: lanjiwei <br/>
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
