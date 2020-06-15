package com.platinumcat.Service.impl;

import com.platinumcat.Service.IDeptSer;
import com.platinumcat.dao.impl.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptSer implements IDeptSer {
    @Autowired
    private DeptDao deptDao;
    public String findAll() {
        return deptDao.findAll();
    }
}
