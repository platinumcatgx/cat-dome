package com.platinumcat.dao.impl;

import com.platinumcat.dao.IEmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao implements IEmpDao {

    @Autowired
    private IEmpDao empDao;

    public String findAll() {
        return "deptDao的findAll方法执行了";
    }
}
