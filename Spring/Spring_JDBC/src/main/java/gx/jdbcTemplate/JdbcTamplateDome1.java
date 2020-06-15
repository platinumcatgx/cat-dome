package gx.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTamplateDome1 {

    public static void main(String[] args) {
        //准备数据源:spring的内置数据源
        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName("com.mysql.jdbc.Driver");
        dmd.setUrl("jdbc:mysql:///test");
        dmd.setUsername("root");
        dmd.setPassword("1234");
        //创建对象
        JdbcTemplate jt = new JdbcTemplate();
        //设置数据源
        jt.setDataSource(dmd);
        jt.execute("select * from chucun");


    }

}
