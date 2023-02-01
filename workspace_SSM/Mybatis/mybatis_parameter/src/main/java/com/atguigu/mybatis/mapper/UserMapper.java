package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Description: <br/>
 * date: 2022/12/9$ 17:13$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface UserMapper {
    /**
     * 通过名字查询
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 验证登录
     * @param name
     * @param password
     * @return
     */
    User checkLogin(String name ,String password);

    /**
     * 验证登录以集合的方式
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录使用@Param注解
     * @param name
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("name") String name, @Param("password") String password);

    /**
     * 获取数量，返回值类型为Integer
     * @return
     */
    Integer getCount();

    /**
     * 通过map集合获取
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转化为map集合
     * 此时有两种方案
     * 1.将mapper接口方法的返回值设置为泛型是map的list集合（List<Map<String,Object>>）
     *
     * 2.可以将每条数据转换为的map集合放在一个大的map中，但是必须要通过 @MapKey注解
     * 将查询的某个字段的值作为大的map的键
     * @return
     */
    @MapKey("id")
//    List<Map<String,Object>> getAllUserToMap();
    Map<String,Object> getAllUserToMap();

    /**
     * 模糊搜素(通过用户名查询)
     * @return
     */
    List<User> getUserByLike(@Param("mohu") String mohu);

    /**
     * 添加用户信息并获得对应的主键
     * @param user
     */
//    void insertUserGetKey(User user);

}
