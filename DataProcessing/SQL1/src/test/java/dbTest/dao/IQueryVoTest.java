package dbTest.dao;

import DBTest.dao.IQueryVo;
import DBTest.domain.Emp;
import DBTest.domain.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IQueryVoTest {
    InputStream in = null;
    SqlSession sqlSession = null;
    IQueryVo mapper;

    @Before
    public void beform(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfigDBTest.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(in);
            sqlSession = factory.openSession();
            mapper = sqlSession.getMapper(IQueryVo.class);
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
    public void aVoid(){
        QueryVo queryVo = new QueryVo();
        Emp emp = new Emp();
        emp.setEname("%木%");
        queryVo.setEmp(emp);
        List<Emp> mu = mapper.findMu(queryVo);
        for (Emp e :
                mu) {
            System.out.println(e.toString());
        }

    }

    @Test
    public void findInIds(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(7034);
        list.add(7934);
        QueryVo vo = new QueryVo();
        vo.setIds(list);
        List<Emp> inIds = mapper.findInIds(vo);
        for (Emp e : inIds){
            System.out.println(e.toString());
        }
    }

}
