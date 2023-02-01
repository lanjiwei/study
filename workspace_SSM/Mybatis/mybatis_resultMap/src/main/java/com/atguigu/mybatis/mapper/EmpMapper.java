package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * Description: <br/>
 * date: 2022/12/12$ 15:45$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface EmpMapper {

    /**
     * 通过id获取emp
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
}
