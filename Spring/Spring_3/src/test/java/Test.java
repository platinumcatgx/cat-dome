import gx.dao.IDeptDao;
import gx.domain.Dept;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = gx.config.SpringConfig.class)
public class Test {
    @Resource(name = "deptDao")
    IDeptDao deptDao = null ;

    @org.junit.Test
    public void TestDeptDao(){
        List<Dept> allDept = deptDao.findAllDept();
        for (Dept d: allDept)
            System.out.println(d);
    }
}
