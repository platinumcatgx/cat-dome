package gx.servers.Impl;

import gx.dao.IEmpDao;
import gx.domain.Emp;
import gx.servers.IEmpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpService implements IEmpService {

    /**
     * 按照id注入
     */
    @Resource(name = "empDao")
    private IEmpDao empDao = null;

    /**
     * z注入基本类型
     */
    @Value("张飞")
    private String name;

    public List<Emp> findAllEmp() {
        System.out.println(name);
        return empDao.findAllEmp();
    }

    @PreDestroy
    public void decdtoy(){
        System.out.println("emp对象销毁了");
    }
    @PostConstruct
    public void PostConstruct(){
        System.out.println("emp初始化了");
    }
}
