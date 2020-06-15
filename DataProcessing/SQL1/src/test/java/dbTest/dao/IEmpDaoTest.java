package dbTest.dao;

import DBTest.dao.IEmpDao;
import DBTest.domain.Emp;
import DBTest.domain.Emp2;
import DBTest.domain.EmpDept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IEmpDaoTest {
    InputStream in = null;
    SqlSession sqlSession = null;
    IEmpDao emps;

    @Before
    public void beform(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfigDBTest.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(in);
            sqlSession = factory.openSession();
            emps = sqlSession.getMapper(IEmpDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @After
    public void after(){
        try {
            sqlSession.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest(){
        List<Emp> emps1 = emps.findAll();
        for (Emp e : emps1){
            System.out.println(e.toString());
        }
    }

    @Test
    public void findMgr(){
        Integer mgr = emps.findMgr("刘一");
        System.out.println(mgr);
    }

    @Test
    public void findMgrUp(){
        List<Emp> mgrUp = emps.findMgrUp("刘一");
        for (Emp e:mgrUp){
            System.out.println(e.toString());
        }
    }

    @Test
    public void Save(){
        Emp e = new Emp();
        e.setEmpno(7034);
        e.setEname("木的钱");
        e.setJob("职员");
        e.setMgr(7782);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        e.setHiredate(null);
        e.setSal(130000);
        e.setComm(null);
        e.setDeptno(10);
        int save = emps.Save(e);
        sqlSession.commit();
        System.out.println(save);
    }

    @Test
    public void Update(){
        int update = emps.Update(100);
        System.out.println(update);
        sqlSession.commit();
    }

    @Test
    public void Delete(){
        int i = emps.deleteOfSal(130000);
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void findEnameMoHu(){
        List<Emp> mu = emps.findEnameMoHu("木");
        for (Emp e : mu) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void findAllEmp(){
        int allEmp = emps.findAllEmp();
        System.out.println(allEmp);
    }

    @Test
    public void ResultMap(){
        List<Emp2> es = emps.findEmp2();
        System.out.println(es.size());
        System.out.println(es.get(0).toString());
        for (Emp2 e : es) {
            System.out.println(e);
        }
    }

    @Test
    public void findEmpsTest(){
        Emp aemp = new Emp();
        aemp.setEname("刘一");
        List<Emp> emps = this.emps.findEmps2(aemp);
        for(Emp e:emps){
            System.out.println(e.toString());
        }
    }

    @Test
    public void findAllEmpDeptTest(){
        List<EmpDept> allEmpDept = emps.findAllEmpDept();
        for (EmpDept e :
                allEmpDept) {
            System.out.println(e.toString());
        }
    }

}
