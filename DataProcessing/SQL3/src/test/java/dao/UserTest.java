package dao;

import gx1.dao.IUserDao;
import gx1.domain.Role;
import gx1.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    SqlSession session;
    IUserDao userDao;
    @Before
    public void b() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(Resources.getResourceAsStream("SqlMap.xml"));
        session = build.openSession(true);
        userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void a(){
        session.close();
    }
    @Test
    public void findAll(){
        List<User> all = userDao.findAll();
        for (User u: all){
            System.out.println(u);
            System.out.println(u.getRoles());
            System.out.println("--------------------------------------------------------");
        }
    }

}
