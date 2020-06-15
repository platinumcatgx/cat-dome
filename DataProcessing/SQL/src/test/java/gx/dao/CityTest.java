package gx.dao;

import gx.domain.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CityTest {

    @Test
    public void findAllTest(){
        InputStream in=null;
        SqlSession session=null;
        try {
            //1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建 SqlSessionFactory 的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建工厂对象 SqlSessionFactory
            SqlSessionFactory factory = builder.build(in);
            //4.使用 SqlSessionFactory 生产 SqlSession 对象
            session = factory.openSession();
            ICityDao mapper = session.getMapper(ICityDao.class);
            List<City> cityList = mapper.findAll();
            for (City c : cityList){
                System.out.println(c.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
