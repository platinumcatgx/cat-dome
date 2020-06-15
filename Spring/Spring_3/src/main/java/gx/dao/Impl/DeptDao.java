package gx.dao.Impl;

import gx.dao.IDeptDao;
import gx.domain.Dept;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * IDeptDao的实现类,让services调用
 */
@Repository("deptDao")
public class DeptDao implements IDeptDao {

    private static IDeptDao deptDao;

    @PostConstruct
    public void CreateDeptDao(){
        try {
            InputStream is = new FileInputStream("D:\\Pro\\Java\\Spring\\Spring_3\\src\\main\\resources\\SqlConfig.xml");
            deptDao = deptDao = new SqlSessionFactoryBuilder().build(is).openSession(true).getMapper(gx.dao.IDeptDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Dept> findAllDept() {
        return deptDao.findAllDept();
    }

    public int Save(Dept dept) {
        return deptDao.Save(dept);
    }

}
