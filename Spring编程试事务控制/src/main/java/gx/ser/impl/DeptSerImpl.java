package gx.ser.impl;

import gx.dao.impl.DeptDaoImpl;
import gx.domain.Dept;
import gx.ser.IDeptSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service("deptSer")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DeptSerImpl implements IDeptSer {

    @Autowired
    private DeptDaoImpl deptDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public List<Dept> findAll(Integer id) {
        return deptDao.findAll(id);
    }

//    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void Update(final Dept dept) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                deptDao.Update(dept);
//                dept.setDeptno(80);
//            int k = 0/0;
                deptDao.Update(dept);
                return null;
            }
        });

    }

}
