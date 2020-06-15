import gx.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext ca = new ClassPathXmlApplicationContext("aop.xml");
        IAccountService bean = ca.getBean("accountservice", IAccountService.class);
        bean.Save();
        bean.Update(1);
        int delete = bean.Delete();
        System.out.println(delete);
    }
}
