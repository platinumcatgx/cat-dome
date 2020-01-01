package com.qq.server.db;

import com.qq.common.Message;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


/**
 * ClassName: Operation
 * @Description: 对数据库进行相关操作
 * @author Emma56
 */
public class DBSUID {
    private static Connection Conn;//数据库连接对象
    private static String URL = "jdbc:mysql:///jstx";// 连接的数据库地址
    private static String UserName = "root";
    private static String Password = "123456";

    public static Connection getConn(){
        try {
//            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            Conn=DriverManager.getConnection(URL, UserName, Password);//连接数据库
            return Conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *数据库的通用 增 删 改
     * @param sql
     * @param param
     * @return
     */
    public static boolean exeUpdate(String sql,Object ...param){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 数据库的通用 查询
     * @param sql
     * @param param
     * @return
     */
    public static ResultSet exeSelect(String sql,Object... param){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

        }
        return null;
    }

    /**
     * 注册
     * @param id
     * @param psw
     * @return
     */
    public static boolean zhuCe(String id ,String psw){
        ResultSet r = DBSUID.exeSelect("select * from user where id=? ", id);
        if (r==null){//无该ID
            //注册
            return DBSUID.exeUpdate("insert into user values(null,?,?)",id,psw);
        }else {//账号已存
            return false;
        }
    }

    /**
     * 登录
     * @param id
     * @param psw
     * @return
     */
    public static boolean dengLu(String id ,String psw){
        ResultSet r = DBSUID.exeSelect("select * from user where id=? and password=? ", id,psw);
        if (r==null){//账号或密码错误
            //注册
            return false;
        }else {//账号已存
            return true;
        }
    }


    /**
     * 将消息添加到数据库
     * @param ms 消息对象
     * @return
     */
    public static boolean addMassage(Message ms){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(new Date(System.currentTimeMillis()));
        return DBSUID.exeUpdate("insert into lt values(null,?,?,?,?);",ms.getSender(),ms.getGetter(),ms.getCon(),time);//存储消息并返回
    }


}

