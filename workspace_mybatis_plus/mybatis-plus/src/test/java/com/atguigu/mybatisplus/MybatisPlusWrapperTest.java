package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Description: <br/>
 * date: 2023/1/9$ 17:53$<br/>
 *
 * @author: lanjiwei <br/>
 */
@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SELECT id,user_name AS name,age,password,gender,is_deleted
        // FROM t_user
        // WHERE is_deleted=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND password IS NOT NULL)
        queryWrapper.like("user_name","a").between("age",10,20).isNotNull("password");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //asc升序 desc降序
        //查询用户信息，按照年龄的降序排序，若年龄相同，按照id升序排序
        //SELECT id,user_name AS name,age,password,gender,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        //删除功能
        // UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (password IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("password");
        int result = userMapper.delete(queryWrapper);
        System.out.println(result);
    }

    @Test
    public void test04(){
        //年龄大于20并且用户中包含a或密码为null的用户信息修改
        //UPDATE t_user SET user_name=?, password=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR password IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.gt("age",20).like("user_name","a").or().isNull("password");
        User user = new User();
        user.setName("小明");
        user.setPassword("com.atguigu");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result"+result);

    }

    @Test
    public void test05(){
        //用户中包含a并且(年龄大于20或密码为null)的用户信息修改(使用QueryWrapper)
        //UPDATE t_user SET user_name=?, password=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR password IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name","a").and(i->i.gt("age",20).or().isNull("password"));
        User user = new User();
        user.setName("小红");
        user.setPassword("com.ljw");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result"+result);
    }

    @Test
    public void test06(){
        //查询用户的姓名，年龄，密码
        //SELECT user_name,age,password FROM t_user WHERE is_deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name","age","password");
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //查询id小于等于100的用户信息(子查询实现)
        //SELECT id,user_name AS name,age,password,gender,is_deleted FROM t_user WHERE is_deleted=0 AND (id IN (select id from t_user where id <= 100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id <= 100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test08(){
        //用户中包含a并且(年龄大于20或密码为null)的用户信息修改(使用updateWrapper)
        //UPDATE t_user SET user_name=?,password=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR password IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>();
        updateWrapper.like("user_name","a")
                .and(i-> i.gt("age",10).or().isNull("password"));
        updateWrapper.set("user_name","小黑").set("password","abc.com.ljw");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+result);
    }

    @Test
    public void test09(){
        //SELECT id,user_name AS name,age,password,gender,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String userName = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(userName)){
            //判断某个字符串是否不为空字符串，不为null，不为空白符
            queryWrapper.like("user_name",userName);
        }

        if(ageBegin != null){
            queryWrapper.ge("age",ageBegin);
        }

        if(ageEnd != null){
            queryWrapper.le("age",ageEnd);
        }

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test10(){
        //SELECT id,user_name AS name,age,password,gender,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String userName = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName),"user_name",userName)
                .ge(ageBegin !=null,"age",ageBegin)
                .le(ageEnd != null ,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void test11(){
        //使用LambdaQueryWrapper查询
        //SELECT id,user_name AS name,age,password,gender,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String userName = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName),User::getName,userName)
                .ge(ageBegin != null,User::getAge,20)
                .le(ageEnd != null,User::getAge,30);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test12(){
        //使用LambdaUpdateWrapper修改
        //UPDATE t_user SET user_name=?,password=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR password IS NULL))
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>();
        updateWrapper.like(User::getName,"a")
                .and(i-> i.gt(User::getAge,10).or().isNull(User::getPassword));
        updateWrapper.set(User::getName,"小黑").set(User::getPassword,"abc.com.ljw");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result:"+result);
    }


}
