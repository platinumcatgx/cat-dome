import io.github.platinumcatgx.domain.Dept;
import io.github.platinumcatgx.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class test {
//    @Autowired
//    private DeptServiceImpl deptService;


    @Test
    public void testFindAll() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        DeptServiceImpl deptService = classPathXmlApplicationContext.getBean("ds", DeptServiceImpl.class);
        List<Dept> all1 = deptService.findAll();
    }

//    @Test
//    public void testFindById() {
//        Dept byId = deptService.findById(3);
//    }
//
//    @Test
//    public void testInsert() {
//        deptService.Insert(null);
//    }
//
//    @Test
//    public void testUpdate() {
//        deptService.Update(null);
//    }
//
//    @Test
//    public void testDelete() {
//        deptService.Delete(null);
//    }

}
