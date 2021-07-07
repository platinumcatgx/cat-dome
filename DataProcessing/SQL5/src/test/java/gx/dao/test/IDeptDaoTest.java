package gx.dao.test;

import gx.dao.IDeptDao;
import gx.dao.IEmpDao;
import gx.domain.Dept;
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

public class IDeptDaoTest {
    InputStream in;
    SqlSession sqlSession;
    IDeptDao mapper;
    @Before
    public void info() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(in);
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(IDeptDao.class);
    }
    @After
    public void det() throws IOException {
        in.close();
        sqlSession.close();
    }

    @Test
    public void findAllTest(){
        List<Dept> all = mapper.findAll();
        for (Dept d : all)
            System.out.println(d);
    }
    @Test
    public void saveTest(){
        Dept dept = new Dept(50,"华山派","武当山");
        int save = mapper.Save(dept);
        System.out.println(save);
    }
    @Test
    public void Update(){
        Dept dept = new Dept(50,"武当派","武当山");
        int update = mapper.Update(dept);
        System.out.println(update);
    }
    @Test
    public void delete(){
        int delete = mapper.delete(50);
        System.out.println(delete);
    }
    @Test
    public void findOne(){
        Dept one = mapper.findOne(10);
        System.out.println(one);
    }
    @Test
    public void findByEname(){
        List<Dept> byEname = mapper.findByEname("%部%");
        for (Dept d:byEname)
            System.out.println(d);
    }
    @Test
    public void findTota(){
        int tota = mapper.findTota();
        System.out.println(tota);
    }


}
