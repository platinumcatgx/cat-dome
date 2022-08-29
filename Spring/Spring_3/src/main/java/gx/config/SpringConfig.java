package gx.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Configurable//声明这是一个配置类
@ComponentScan(basePackages = "gx")//要扫描的包
//@Import(PropertySource.class)//导入其他配置类,支持父子关系
@Import(PropertySource.class)
public class SpringConfig {

}
