import gx.domain.Dept;
import gx.ser.IDeptSer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = config.SpringConfig.class)
public class TestService {

    @Autowired
    IDeptSer ds;
    @Test
    public void TestFindAll(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IDeptSer ds = ac.getBean("ds", IDeptSer.class);

        Dept dept = new Dept();
        dept.setDeptno(60);

        ds.Update(dept);
    }

}
