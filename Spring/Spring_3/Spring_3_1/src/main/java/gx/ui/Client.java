package gx.ui;

import gx.config.SpringConfig;
import gx.domain.Dept;
import gx.servers.IDeptService;
import gx.servers.Impl.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

public class Client {

    public static ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static void main(String[] args) throws IOException {
        DeptService deptService = ac.getBean("deptService", DeptService.class);
        for (Dept d:deptService.findAllDept())
            System.out.println(d);
        String jdbcStrs1 = ac.getBean("jdbcStrs1", String.class);
        System.out.println(jdbcStrs1);
    }

}
