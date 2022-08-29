package gx.dao.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class DeptDao implements IDeptDao {

    private static SqlSession sqlSession;
    private static IDeptDao mapper;

    static {
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlConfig.xml")).openSession(true);
            mapper = sqlSession.getMapper(IDeptDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dept> findAllDept() {
        return mapper.findAllDept();
    }

    public int Save(Dept dept) {
        return mapper.Save(dept);
    }
}
