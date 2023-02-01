package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entity.Emp;
import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description: <br/>
 * date: 2022/12/13$ 9:54$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class DynamicTest {
    @Test
    public void getEmpByConditionTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"张三",20,"男");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void insertMoreEmpTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"小明",20,"男");
        Emp emp2 = new Emp(null,"小红",20,"女");
        Emp emp3 = new Emp(null,"小亮",20,"男");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(list);
    }
}
