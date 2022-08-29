package io.github.platinumcatgx.dao.impl;

import io.github.platinumcatgx.dao.DeptDao;
import io.github.platinumcatgx.domain.Dept;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

import java.util.List;

public class DeptDaoImpl extends JdbcDaoSupport implements DeptDao {

    public List<Dept> findAll() {
        System.out.println("执行了findall");
        return null;
    }

    public Dept findById(Integer id) {
        System.out.println("执行了findById"+id);
        return null;
    }

    public void Update(Dept dept) {
        System.out.println("执行了Update"+dept);
    }

    public void Insert(Dept dept) {
        System.out.println("执行了Insert"+dept);
    }

    public void Delete(Dept dept) {
        System.out.println("执行了Delete"+dept);
    }
}
