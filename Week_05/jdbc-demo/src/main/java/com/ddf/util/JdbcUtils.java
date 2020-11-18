package com.ddf.util;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcUtils {



    private static Connection conn = null;
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            DataSource dataSource = HikariUtils.dataSource();
            conn = dataSource.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }

}