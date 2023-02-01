package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Dept;
import com.atguigu.mybatis.entity.Emp;
import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Description: <br/>
 * date: 2022/12/12$ 15:56$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class ResultMapTest {
    @Test
    public void getEmpByEmpIdTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);

    }
    @Test
    public void getEmpAndDeptByEmpIdTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void  getDeptAndEmpByDepyIdTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDepyId(1);
        System.out.println(dept);


    }
}
