package config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configurable
@ComponentScan(basePackages = "gx.*")
@PropertySource("jdbcConfig.properties")
@Import({JdbcConfig.class,Tm.class})
@EnableTransactionManagement//开启spring对注解事务的支持
public class SpringConfig {



}

