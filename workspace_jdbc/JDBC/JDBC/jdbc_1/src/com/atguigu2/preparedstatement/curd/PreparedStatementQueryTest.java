package com.atguigu2.preparedstatement.curd;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Description: <br/>
 * date: 2022/11/24$ 14:41$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetInstance(){
        String sql = "select id,name,email from customers where id = ?";
        Customer customer = getInstance(Customer.class,sql,12);
        System.out.println(customer);
    }

    //通用的查询操作(只查询一条数据，若多条,将T改成list<T>)
    public <T> T getInstance(Class<T> clazz,String sql ,Object ...args){
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
                //java9以后clazz.newInstance()已经过时了

                T t = clazz.getDeclaredConstructor().newInstance();

                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名（不推荐使用）
//                    String columnName = rsmd.getColumnName(i+1);
                    //获取别名（数据库列名与java类的属性名不对应，需要起别名，若没有别名，返回的还是列名）
                    String columnLable = rsmd.getColumnLabel(i+1);
                    //给cust对象指定的columnName属性，赋值为columValue
                    Field field = clazz.getDeclaredField(columnLable);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return  null;
    }
}
