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

public class empTest {
    InputStream in;
    SqlSession sqlSession;
    IEmpDao empDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        sqlSession = sessionFactory.openSession(true);
        empDao = sqlSession.getMapper(IEmpDao.class);
    }
    @After
    public void de() throws IOException {
        in.close();
        sqlSession.close();
    }

    @Test
    public void findAll(){
        List<Emp> empList = empDao.findAll();
        for (Emp emp : empList){
            System.out.println(emp);
        }
    }

    @Test
    public void findById(){
        List<Emp> byId = empDao.findById(30);
        for (Emp e : byId)
            System.out.println(e);
    }


}
