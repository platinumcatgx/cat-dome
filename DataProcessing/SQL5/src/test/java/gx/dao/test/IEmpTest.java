package gx.dao.test;

import gx.dao.IEmpDao;
import gx.domain.Emp;
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

public class IEmpTest {
    InputStream in;
    SqlSession sqlSession;
    IEmpDao mapper;
    @Before
    public void info() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(in);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(IEmpDao.class);
    }
    @After
    public void det() throws IOException {
        in.close();
        sqlSession.close();
    }

    @Test
    public void findAllTest(){
        List<Emp> all = mapper.findAll();
        for (Emp e : all)
            System.out.println(e);
    }
    @Test
    public void saveTest(){
        Emp emp = new Emp();
        emp.setDeptno(7000);
        emp.setEname("张三丰");
        emp.setEmpno(10);
        int i = mapper.SaveEmp(emp);
        System.out.println(i);
    }


}
