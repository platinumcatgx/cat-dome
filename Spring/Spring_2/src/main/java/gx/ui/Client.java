package gx.ui;

import gx.domain.bean1;
import gx.domain.bean2;
import gx.domain.bean3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Client {

    /**
     *
     * Spring的 IOC 能解决什么问题
     *
     * 如何搭建Spring的基于XML开发环境
     *
     * 如何实现类之间的依赖关系,使用Spring来维护
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//
//        IDeptService deptService = ac.getBean("deptService", IDeptService.class);
//
//        List<Dept> allDept = deptService.findAllDept();
//        for (Dept d : allDept)
//            System.out.println(d);

        bean1 bean1 = ac.getBean("dept", bean1.class);
        bean2 bean2 = ac.getBean("bean2", bean2.class);
        bean3 bean3 = ac.getBean("bean3", bean3.class);
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);

    }

}
