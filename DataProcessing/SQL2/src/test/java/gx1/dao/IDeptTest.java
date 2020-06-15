package gx1.dao;

import gx1.domain.Dept;
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

public class IDeptTest {
    InputStream in;
    SqlSession session;
    IDeptDao deptDao;

    @Before
    public void BeFor() throws IOException {
        in = Resources.getResourceAsStream("SqlMap.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession(true);
        deptDao = session.getMapper(IDeptDao.class);
    }
    @After
    public void AfTer() throws IOException {
        in.close();
        session.close();
    }

    @Test
    public void findAll(){
        List<Dept> all = deptDao.findAll();
        for (Dept a : all)
            System.out.println(a.toString());
    }
    @Test
    public void findAllEmp() {
        List<Dept> allEmp = deptDao.findAllEmp();
        for (Dept d : allEmp)
            System.out.println(d.toString());
    }
}
