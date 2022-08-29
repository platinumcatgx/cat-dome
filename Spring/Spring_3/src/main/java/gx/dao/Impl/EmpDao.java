package gx.dao.Impl;

import gx.dao.IEmpDao;
import gx.domain.Emp;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * IEmpDao的实现类,让services调用
 */
@Repository("empDao")
public class EmpDao implements IEmpDao {

    private static IEmpDao empDao;

    @PostConstruct
    public void CreateDeptDao(){
        try {
            InputStream is = new FileInputStream("D:\\Pro\\Java\\Spring\\Spring_3\\src\\main\\resources\\SqlConfig.xml");
            empDao = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(IEmpDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Emp> findAllEmp() {
        return empDao.findAllEmp();
    }

    public List<Emp> findByID(Integer deptno) {
        return empDao.findByID(deptno);
    }

}
