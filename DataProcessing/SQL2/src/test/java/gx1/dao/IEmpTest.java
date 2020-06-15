package gx1.dao;

import gx1.domain.Emp;
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
    SqlSession session;
    IEmpDao empDao;

    @Before
    public void BeFor() throws IOException {
        in = Resources.getResourceAsStream("SqlMap.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession(true);
        empDao = session.getMapper(IEmpDao.class);
    }
    @After
    public void AfTer() throws IOException {
        in.close();
        session.close();
    }
    @Test
    public void findAll(){
        List<Emp> all = empDao.findAll();
        for (Emp a : all)
            System.out.println(a.toString());
    }
    @Test
    public void findAllEmp(){
        List<Emp> allEmp = empDao.findAllEmp();
        for (Emp e : allEmp)
            System.out.println(e.toString());
    }


}
