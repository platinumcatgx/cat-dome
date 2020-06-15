package gx.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 指定properties,并根据'键'读取'值'的内容
 */
@org.springframework.context.annotation.PropertySource("classpath:jdbc.properties")
public class PropertySource {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 给方法参数注入时,可以直接使用
     * bean 的 name随便取的,因为只是测试一下,并不会去使用
     * @param driver
     */
    @Bean(name = "pjc1")
    public static String printJDBCDriver(@Qualifier("jdbcConfig") String driver){
        System.out.println(driver);
        return driver;
    }

    /**
     * 输出配置文件中的值
     * @return
     */
    @Bean(name = "jdbcConfig")
    public String jdbc(){
        System.out.println(driver+url+username+password);
        return driver+url+username+password;
    }

    @Bean(name = "jc1")
    public String jdbc1(){
        System.out.println(driver+url+username+password+"hahahahah");
        return driver+url+username+password;
    }

}
