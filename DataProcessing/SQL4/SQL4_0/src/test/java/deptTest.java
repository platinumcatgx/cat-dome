import gx.dao.IDeptDao;
import gx.domain.Dept;
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

public class deptTest {
    InputStream in;
    SqlSession sqlSession;
    IDeptDao empDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        sqlSession = sessionFactory.openSession(true);
        empDao = sqlSession.getMapper(IDeptDao.class);
    }
    @After
    public void de() throws IOException {
        in.close();
        sqlSession.close();
    }

    @Test
    public void findAll(){
        List<Dept> deptList = empDao.findAll();
        for (Dept dept : deptList){
            System.out.println(dept);
        }
    }
    @Test
    public void find2(){
        List<Dept> depts = empDao.find2();
        for (Dept dept : depts ){
            System.out.println(dept);
            System.out.println(dept.getEmps());
        }
    }
}
