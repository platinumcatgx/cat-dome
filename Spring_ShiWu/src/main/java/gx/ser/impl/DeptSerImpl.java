package gx.ser.impl;

import gx.dao.IDeptDao;
import gx.dao.impl.DeptDaoImpl;
import gx.domain.Dept;
import gx.domain.MyJava;
import gx.ser.IDeptSer;

import java.util.List;

public class DeptSerImpl implements IDeptSer {

    private DeptDaoImpl deptDao;

    public void setDeptDao(DeptDaoImpl deptDao) {
        this.deptDao = deptDao;
    }

    public List<Dept> findAll(Integer id) {
        return deptDao.findAll(id);
    }

    public void Update(Dept dept) {
            deptDao.Update(dept);
            dept.setDeptno(80);
//            int k = 0/0;
            deptDao.Update(dept);
    }

}
