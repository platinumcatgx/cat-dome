package gx.jdbcTemplate;

import gx.dao.IEmpDao;
import gx.domain.emp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTamplateDome3 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IEmpDao empdao = ac.getBean("empdao", IEmpDao.class);
        emp byId = empdao.findById(7034);
        System.out.println(byId);

    }

}
