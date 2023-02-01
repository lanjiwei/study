package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Description: <br/>
 * date: 2022/12/9$ 17:33$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class ParameterTest {
    @Test
    public void getUserByNameTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("admin");
        System.out.println(user);
    }

    @Test
    public void checkLoginTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root", "123");
        System.out.println(user);
    }

    @Test
    public void checkLoginByMapTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void insertUserTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("帅哥",20,"654321","男");
        mapper.insertUser(user);
//        System.out.println(user);
    }

    @Test
    public void  checkLoginByParamTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("帅哥", "654321");
        System.out.println(user);
    }


    @Test
    public void getCountTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void getUserByIdToMapTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(1);
//        {password=123456, gender=男, name=admin, id=1, age=18}
        //如果查询出的结果有字段为null，不会放在map集合中
        System.out.println(map);
    }

    @Test
    public void getAllUserToMapTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<Map<String, Object>> list = mapper.getAllUserToMap();
//        list.forEach(System.out::println);
        /**
         * {
         * 1={password=123456, gender=男, name=admin, id=1, age=18},
         * 2={password=123, gender=女, name=root, id=2, age=20},
         * 4={password=654321, gender=男, name=帅哥, id=4, age=20}
         * }
         */
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
//        System.out.println(list);

    }
    @Test
    public void getUserByLikeTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }

}
