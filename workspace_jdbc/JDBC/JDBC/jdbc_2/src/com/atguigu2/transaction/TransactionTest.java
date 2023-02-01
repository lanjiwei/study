package com.atguigu2.transaction;

import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Description: <br/>
 * date: 2022/11/28$ 14:03$<br/>
 *
 * @author: lanjiwei <br/>
 */
public class TransactionTest {

   /*
   //泛型方法
    public <T> void print(T ...args){
        for (T t : args) {
            System.out.println("t is" + t);
            System.out.println(t.getClass().toString());
        }
    }
    //普通方法
    public void print1(String ...args){
        for (String t : args) {
            System.out.println("t is" + t);
//            System.out.println(t.getClass().toString());
        }
    }

    //泛型方法允许传入的参数的类型是不确定的，并且可以有多个类型
    @Test
    public void test(){
        TransactionTest tt = new TransactionTest();
        tt.print("111",222,"aaaa","2323.4",55.55);
    }
    */



    @Test
    public void transactionTest()  {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            conn.setAutoCommit(false);

            String sql1 = "update user_table set balance = balance - 100 where name = ?";
            update(conn,sql1,"AA");

            //模拟网络异常
            System.out.println(10/0);

            String sql2 = "update user_table set balance = balance + 100 where name = ?";
            update(conn,sql2,"BB");

            System.out.println("转账成功");


            conn.commit();
        } catch (Exception e) {
             e.printStackTrace();
             //回滚
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {

            //主要针对于数据库连接池
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResource(conn,null);

        }

    }

    public int update(Connection conn,String sql ,Object ...args)  {

        PreparedStatement ps = null;
        try {

            //1.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //3.执行
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            JDBCUtils.closeResource(null,ps);
        }
        return 0;

    }
}
