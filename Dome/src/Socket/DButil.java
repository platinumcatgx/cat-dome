package Socket;

import org.junit.Test;

import java.sql.*;

public class DButil {
//    static {//注册驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private static Connection getconn(){//获取连接
        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dome");
            return DriverManager.getConnection("jdbc:mysql:///dome_qq?serverTimezone=UTC","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * MySQL的增删改执行方法
     * @param sql sql语句
     * @param obj 参数
     * @return 是否成功
     */
    public static boolean update(String sql , Object...obj){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn=getconn();
            ps=conn.prepareStatement(sql);//获取preparStatement对象
            for(int i=0;i<obj.length;i++){
                ps.setObject(i+1,obj[i]);//给SQL语句添加参数
            }
            return ps.executeUpdate()>0;//受影响的行数 > 0
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
            * MySQL的查询语句
     * @param sql SQL语句
     * @param obj 参数
     * @return 结果集
     */
    public static ResultSet select(String sql,Object...obj){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn=getconn();
            ps=conn.prepareStatement(sql);
            for(int i=0;i<obj.length;i++){
                ps.setObject(i+1,obj[i]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Test
    public void getconnTest(){
        if(DButil.getconn()!=null)
            System.out.println("true");
    }

}
