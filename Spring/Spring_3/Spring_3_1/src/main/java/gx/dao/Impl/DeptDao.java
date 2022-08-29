package gx.dao.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * IDeptDao的实现类,让services调用
 */
@Repository
public class DeptDao implements IDeptDao {

    @Autowired
    @Qualifier("sqlSession")
    private static SqlSession sqlSession=null;
    private static IDeptDao mapper;

    @PostConstruct
    private void init() throws IOException {
        sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlConfig.xml")).openSession(true);
        mapper = sqlSession.getMapper(IDeptDao.class);
    }
    @PreDestroy
    private void dir(){
        sqlSession.close();
    }

    public List<Dept> findAllDept() {
        return mapper.findAllDept();
    }


}
