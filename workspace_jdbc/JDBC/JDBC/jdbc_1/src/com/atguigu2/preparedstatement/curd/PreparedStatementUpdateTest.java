package com.atguigu2.preparedstatement.curd;

import com.atguigu.connection.ConnectionTest;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 *  使用PrepareStatement来代替Statement，实现对数据表的增删改操作
 */
public class PreparedStatementUpdateTest {

    /**
     * 通用的增删改操作
     */
    //更新操作
    public int update(String sql ,Object ...args)  {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.创建链接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4.执行
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源关闭
            JDBCUtils.closeResource(conn,ps);
        }
        return 0;

    }



    //完整的插入操作
    @Test
    public void  testInsert()  {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的4个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driveClass = pros.getProperty("driveClass");

            //2.加载驱动
            Class.forName(driveClass);

            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);

            //4.预编译sql语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth) value(?,?,?)"; //?叫占位符
            ps = conn.prepareStatement(sql);
            //5.填充占位符
            ps.setString(1,"蔡徐坤");
            ps.setString(2,"caixukun@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3,new Date(date.getTime()));

            //6.执行sql
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  finally {
            //7.资源的关闭
            try {
                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }





    }
}
