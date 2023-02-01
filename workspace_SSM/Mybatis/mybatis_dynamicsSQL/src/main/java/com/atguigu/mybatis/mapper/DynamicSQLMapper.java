package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description: <br/>
 * date: 2022/12/13$ 9:45$<br/>
 *
 * @author: lanjiwei <br/>
 */
public interface DynamicSQLMapper {
    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);
}
