package gx.dao.impl;

import gx.dao.IEmpDao;
import gx.domain.emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户的持久层实现类
 */
public class empDao implements IEmpDao {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }


    public emp findById(int id) {
        List<emp> query = jt.query("select * from emp where empno = ? ", new BeanPropertyRowMapper<emp>(emp.class), id);
        return query.isEmpty()?null:query.get(0) ;
    }

    public emp findByName(String name) {
        List<emp> query = jt.query("select * from emp where ename = ? ", new BeanPropertyRowMapper<emp>(emp.class), name);
        if (query.isEmpty()){
            return null;
        }
        if (query.size()>1){
            throw new RuntimeException("结果不唯一");
        }
        return query.get(0);
    }

    public void updateEmp(emp emp) {
        jt.update("update emp set emp.comm=?where emp.empno=?",emp.getComm(),emp.getEmpno());
    }
}
