package gx.dao.impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import gx.domain.MyJava;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class DeptDaoImpl extends JdbcDaoSupport implements IDeptDao {

    public List<Dept> findAll(Integer id) {
        return null;
    }

    public void Update(Dept dept) {
        int update = getJdbcTemplate().update("update dept set deptno= ? where dname = 'a' ",dept.getDeptno());
        System.out.println("更改后----"+update);
    }
}
