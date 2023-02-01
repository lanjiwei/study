package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * date: 2023/1/6$ 15:53$<br/>
 *
 * @author: lanjiwei <br/>
 */
@SpringBootTest
public class MybatisPlusServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetCount(){
        //SELECT COUNT( * ) FROM user
        //查询总数
        int count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testInsertMore(){
        //批量添加
        List<User> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setGender("男");
            user.setPassword("1111");
            user.setAge(10+i);
            user.setName("yy"+i);
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
