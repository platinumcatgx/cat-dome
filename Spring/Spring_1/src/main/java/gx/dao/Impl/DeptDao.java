package gx.dao.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DeptDao implements IDeptDao {

    private static SqlSession sqlSession;
    private static IDeptDao mapper;
    private static IDeptDao mapper1;
    static {

        try {
            InputStream in = Resources.getResourceAsStream("SqlConfig.xml");

//通过Spring核心容器创建JAR包中的类
            SqlSessionFactoryBuilder builder = new ClassPathXmlApplicationContext("bean.xml")
                    .getBean("builder", SqlSessionFactoryBuilder.class);

            SqlSessionFactory build = builder.build(in);
            SqlSession sqlSession1 = build.openSession(true);
            mapper1 = sqlSession1.getMapper(IDeptDao.class);

            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlConfig.xml")).openSession(true);
            mapper = sqlSession.getMapper(IDeptDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dept> findAllDept() {
        return mapper1.findAllDept();
    }

    public int Save(Dept dept) {
        return mapper.Save(dept);
    }
}
