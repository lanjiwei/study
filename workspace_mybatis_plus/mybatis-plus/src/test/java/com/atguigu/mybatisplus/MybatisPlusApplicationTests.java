package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询list集合，若没有条件，设置null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

//        List<Integer> list = Arrays.asList(1, 2, 3);
//        List<User> users = userMapper.selectBatchIds(list);
//        System.out.println(users);

    }

    @Test
    public void testInsert(){
        //新增用户信息
        //INSERT INTO user ( name, age, password, gender ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setPassword("1111");
        user.setGender("男");
        user.setName("张三");
        user.setAge(20);
        int result = userMapper.insert(user);
        System.out.println("result ,"+result);
        System.out.println("id:"+user.getId());
    }

    @Test
    public void testDelete(){
        //根据map集合中的设置的条件删除用户信息
        //DELETE FROM user WHERE name = ? AND age = ?
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name","yaya");
        map.put("age","18");
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    void contextLoads() {
        //lambda表达式
        //条件：类中单抽象方法

        Comparator<Integer> comparator = (o1,o2)-> 1;

        Runnable runnable = () ->{};


//        List list = Arrays.asList(1,2,3);
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//           Integer num  = (Integer)iterator.next();
//            System.out.println(num);
//        }



    }

    @Test
    public void test(){

        String st= "and pd.account > 2    \\r\\n       and pd.create_time is not null 5 \\r\\n       and pd.dept < 5";


    }







}
