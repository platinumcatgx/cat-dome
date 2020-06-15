package gx.ser.impl;

import gx.dao.IDeptDao;
import gx.dao.impl.DeptDaoImpl;
import gx.domain.Dept;
import gx.domain.MyJava;
import gx.ser.IDeptSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deptSer")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DeptSerImpl implements IDeptSer {

    @Autowired
    private DeptDaoImpl deptDao;

    public List<Dept> findAll(Integer id) {
        return deptDao.findAll(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void Update(Dept dept) {
            deptDao.Update(dept);
            dept.setDeptno(80);
//            int k = 0/0;
            deptDao.Update(dept);
    }

}
