package com.atguigu.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driveClass = pros.getProperty("driveClass");

        //2.加载驱动
        Class.forName(driveClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }
}
