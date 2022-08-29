package gx.dao.Impl;

import gx.dao.IEmpDao;
import gx.domain.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class EmpDao implements IEmpDao {

    private static SqlSession sqlSession;
    private static IEmpDao mapper;

    static {
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlConfig.xml")).openSession(true);
            mapper = sqlSession.getMapper(IEmpDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Emp> findAllEmp() {
        return mapper.findAllEmp();
    }

    public List<Emp> findByID(Integer deptno) {
        return mapper.findByID(deptno);
    }

}
