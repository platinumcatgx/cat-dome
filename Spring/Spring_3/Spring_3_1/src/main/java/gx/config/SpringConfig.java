package gx.config;

import gx.dao.IDeptDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;

@Configurable//声明这是一个配置类
@ComponentScan(basePackages = "gx")//要扫描的包
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

    @Bean(name = "jdbcStrs1")
    public String CreateJDBC(@Qualifier("jdbcStrs2") String str){
        return str+"此时,@Qualifier可以单独使用;";
    }
    @Bean(name = "jdbcStrs2")
    public String CreateJDBC2(){
        return "通过@bean创建一个对象;\n";
    }

}
