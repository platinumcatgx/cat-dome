package gx.servers.Impl;

import gx.dao.IDeptDao;
import gx.dao.Impl.DeptDao;
import gx.domain.Dept;
import gx.servers.IDeptService;

import java.util.List;

public class DeptService implements IDeptService {

    IDeptDao deptDao = new DeptDao();

    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }

    public void Save(){
        System.out.println("保存了");
    }

}
