package com.gx.test;

import com.gx.dao.IUserDao;
import com.gx.domain.User;
import mybatis.io.Resources;
import mybatis.sqlSession.SqlSession;
import mybatis.sqlSession.SqlSessionFactory;
import mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis测试
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        //6.释放资源
        sqlSession.close();
        in.close();

    }
}
