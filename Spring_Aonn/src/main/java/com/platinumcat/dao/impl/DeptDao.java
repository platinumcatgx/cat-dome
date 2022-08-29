package com.platinumcat.dao.impl;

import com.platinumcat.dao.IDeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao implements IDeptDao {

    @Autowired
    private IDeptDao deptDao;

    public String findAll() {
        return "deptDao的findAll方法执行了";
    }

}
