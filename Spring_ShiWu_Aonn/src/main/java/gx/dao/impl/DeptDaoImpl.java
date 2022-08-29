package gx.dao.impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import gx.domain.MyJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deptDao")
public class DeptDaoImpl implements IDeptDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dept> findAll(Integer id) {
        return null;
    }

    public void Update(Dept dept) {
        int update = jdbcTemplate.update("update dept set deptno= ? where dname = 'a' ",dept.getDeptno());
        System.out.println("更改后----"+update);
    }
}
