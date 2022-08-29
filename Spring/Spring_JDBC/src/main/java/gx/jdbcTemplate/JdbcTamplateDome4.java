package gx.jdbcTemplate;

import gx.dao.IEmpDao;
import gx.dao.impl.empDao;
import gx.domain.emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTamplateDome4 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IEmpDao empdao = ac.getBean("empdao", IEmpDao.class);
        emp byId = empdao.findById(7034);
        System.out.println(byId);

    }

}
