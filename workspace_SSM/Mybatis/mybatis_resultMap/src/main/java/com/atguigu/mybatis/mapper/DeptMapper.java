package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * Description: <br/>
 * date: 2022/12/12$ 15:47$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface DeptMapper {

    /**
     * 查询部门以及部门中的员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDepyId(@Param("deptId") Integer deptId);
}
