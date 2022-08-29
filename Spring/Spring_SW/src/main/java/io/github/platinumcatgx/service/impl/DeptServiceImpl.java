package io.github.platinumcatgx.service.impl;

import io.github.platinumcatgx.dao.DeptDao;
import io.github.platinumcatgx.domain.Dept;
import io.github.platinumcatgx.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public Dept findById(Integer id) {
        return deptDao.findById(id);
    }

    public void Update(Dept dept) {
        deptDao.Update(dept);
    }

    public void Insert(Dept dept) {
        deptDao.Insert(dept);
    }

    public void Delete(Dept dept) {
        deptDao.Delete(dept);
    }
}
