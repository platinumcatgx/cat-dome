package gx.ui;

import gx.domain.Dept;
import gx.servers.IDeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Client {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IDeptService deptService = ac.getBean("deptService", IDeptService.class);

        List<Dept> allDept = deptService.findAllDept();
        for (Dept d : allDept)
            System.out.println(d);
    }

}
