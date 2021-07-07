package dbTest.dao;

import DBTest.dao.IDeptDao;
import DBTest.domain.Dept;
import DBTest.domain.Dept1;
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

public class IDeptDaoTest {

    InputStream in = null;
    SqlSession sqlSession = null;
    IDeptDao mapper;

    @Before
    public void beform(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfigDBTest.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(in);
            sqlSession = factory.openSession();
            mapper = sqlSession.getMapper(IDeptDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @After
    public void after(){
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest(){
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        List<Dept> all = mapper.findAll();
        for (Dept d : all){
            System.out.println(d.toString());
        }

    }

    @Test
    public void findAllEmp(){
        List<Dept1> allEmp = mapper.findAllEmp();
        for (Dept1 d:allEmp){
            System.out.println(d.toString());
        }
    }

}
