package gx.ui;

import gx.config.SpringConfig;
import gx.dao.Impl.EmpDao;
import gx.domain.Dept;
import gx.domain.Emp;
import gx.servers.IDeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Client {


    public static void main(String[] args) throws IOException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//        IDeptService deptService = ac.getBean("deptService", IDeptService.class);
//
//        List<Dept> allDept = deptService.findAllDept();
//        for (Dept d : allDept)
//            System.out.println("dept===>"+d);
//
//        System.out.println("===================================");
//
//        IEmpService empService = ac.getBean("empService",IEmpService.class);
//        List<Emp> allEmp = empService.findAllEmp();
//        for (Emp e:allEmp)
//            System.out.println("emp===>"+e);
//
//        //获取配置文件中的内容,采用Mybatis,并不用此配置连接
//        String jdbcConfig = (String) ac.getBean("jdbcConfig");
//        System.out.println(jdbcConfig);
        EmpDao empDao = ac.getBean("empDao", EmpDao.class);
        for (Emp e:empDao.findAllEmp())
            System.out.println(e);

        IDeptService bean = ac.getBean(IDeptService.class);
        for (Dept d:bean.findAllDept())
            System.out.println(d);

    }



}
