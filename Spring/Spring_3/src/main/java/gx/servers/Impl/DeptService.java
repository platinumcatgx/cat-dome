package gx.servers.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import gx.servers.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class DeptService implements IDeptService {
    /**
     * 在自动注入的基础上按照id(deptDao)注入
     */
    @Autowired
    @Qualifier("deptDao")
    IDeptDao deptDao = null;

    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }

}
