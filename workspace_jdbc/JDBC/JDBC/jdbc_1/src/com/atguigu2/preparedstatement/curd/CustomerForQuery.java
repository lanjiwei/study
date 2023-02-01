package com.atguigu2.preparedstatement.curd;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.function.BiConsumer;

/**
 * Description: <br/>
 * date: 2022/11/24$ 10:48$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class CustomerForQuery {



    //针对Customer的查询操作(通过反射设置属性)
    @Test
    public Customer queryForCustomers(String sql, Object ...args)  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            //获取结果集中的元数据ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Customer cust = new Customer();

                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名（不推荐使用）
//                    String columnName = rsmd.getColumnName(i+1);
                    //获取别名（数据库列名与java类的属性名不对应，需要起别名，若没有别名，返回的还是列名）
                    String columnLable = rsmd.getColumnLabel(i+1);
                    //给cust对象指定的columnName属性，赋值为columValue
                    Field field = Customer.class.getDeclaredField(columnLable);
                    field.setAccessible(true);
                    field.set(cust,columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return  null;
    }


    //针对customer的查询(通过构造器设置属性)
    @Test
    public void testQuery1()  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth from customers  where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);
            //执行并返回结果集
            resultSet = ps.executeQuery();
            //处理结果集
            if(resultSet.next()){//next():判断结果集的下一条是否有数据，如果有数据返回true，并指向下一条，若没有返回false
                //获取这条数据的各个字段值
                int id = resultSet.getInt(1);
                //指定列名
//                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date brith = resultSet.getDate(4);

                //将数据封装为一个对象
                Customer customer = new Customer(id, name, email, brith);
                System.out.println(customer);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeResource(conn,ps,resultSet);
        }





    }
}
