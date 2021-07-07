package dao;

import gx1.dao.IRoleDao;
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
import java.util.List;

public class RoleDaoTest {
    SqlSession session;
    IRoleDao RoleDao;
    @Before
    public void b() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(Resources.getResourceAsStream("SqlMap.xml"));
        session = build.openSession(true);
        RoleDao = session.getMapper(IRoleDao.class);
    }
    @After
    public void a(){
        session.close();
    }
    @Test
    public void findAll(){
        List<Role> all = RoleDao.findAll();
        for (Role role: all) {
            System.out.println("---每个角色的信息----");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
