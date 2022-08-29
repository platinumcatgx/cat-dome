package gx.servers.Impl;

import gx.dao.IEmpDao;
import gx.domain.Emp;
import gx.dao.Impl.EmpDao;
import gx.servers.IEmpService;

import java.util.List;

public class EmpService implements IEmpService {

    IEmpDao empDao = new EmpDao();

    public List<Emp> findAllEmp() {
        return empDao.findAllEmp();
    }
}
