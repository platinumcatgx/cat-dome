package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
    public static void main(String[] args) {
        try {
            //加载驱动并创建与数据库连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbm_learn","root","123456");

            String sql = "undate learn_01 set name='Jocer' where id='1'";
            Statement st = conn.createStatement();
            System.out.println(st.executeUpdate(sql));
            conn.close();
            st.close();
        } catch (ClassNotFoundException e) {
            System.out.println("连接出错");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
