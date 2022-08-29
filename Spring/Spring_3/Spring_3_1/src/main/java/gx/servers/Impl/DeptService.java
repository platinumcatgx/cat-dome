package gx.servers.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import gx.servers.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {
    @Autowired
    IDeptDao deptDao = null;

    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }

}
