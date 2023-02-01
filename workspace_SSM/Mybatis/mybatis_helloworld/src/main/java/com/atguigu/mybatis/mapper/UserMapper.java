package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.User;

import java.util.List;

/**
 * Description: <br/>
 * date: 2022/12/8$ 15:12$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface UserMapper {
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 更新用户
     */
    void updateUser();

    /**
     * 根据id查询用户
     * @return
     */
    User getUserById();

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();
}
