package com.platinumcat.Service.impl;

import com.platinumcat.Service.IEmpSer;
import com.platinumcat.dao.impl.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpSer implements IEmpSer {
    @Autowired
    private EmpDao empDao ;

    public String findAll() {
        return empDao.findAll();
    }
}
