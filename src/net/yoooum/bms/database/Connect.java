package net.yoooum.bms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Yoooum
 */
public class Connect {
    public Statement connect() {
        try {
            String driver = "org.mariadb.jdbc.Driver";
            //从配置参数中获取数据库url
            String url = "jdbc:mariadb://localhost:3306/books_sys";
            //从配置参数中获取用户名
            String user = "root";
            //从配置参数中获取密码
            String pass = "1234567890dd@";

            //注册驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            //创建Statement对象
            Statement stmt = conn.createStatement();
            System.out.println("mariadb connect success!");
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
