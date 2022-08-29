package gx.ui;

import gx.domain.Dept;
import gx.servers.IDeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Client {

    /**
     * 获取Spring核心容器IOC并根据ID获取对象
     * ApplicationContext三个常用类
     *      ClassPathXmlApplicationContext
     *      FileSystemXmlApplicationContext
     *      AnnotationConfigApplicationContext:读取注解创建容器
     * 核心容器的两个接口引发的问题
     * ApplicationContext:--单例对象适用 --- 使用更多
     *      采用的是立即加载的方式,只要读取完配置文件立即创建
     * BeanFactory:--多例对象适用
     *      延迟加载
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //1.获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据ID获取Bean对象
//        方法一
//        IDeptService deptService = (IDeptService) ac.getBean("accountService");
//        不用 new 关键字了
//        IDeptService deptService = new DeptService();
//        方式二，不用强转
        IDeptService deptService = ac.getBean("deptService", IDeptService.class);


        List<Dept> allDept = deptService.findAllDept();
        for (Dept d : allDept)
            System.out.println(d);
    }

}
