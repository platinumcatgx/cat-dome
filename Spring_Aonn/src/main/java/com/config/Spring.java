package com.config;

import com.platinumcat.dao.IDeptDao;
import com.platinumcat.dao.IEmpDao;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@ComponentScan(basePackages = "com.platinumcat")
public class Spring {

//    @Bean(name = "iEmpDao")
//    public IEmpDao CreateEmpDao(){
//        try {
//            InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory build = builder.build(in);
//            return build.openSession().getMapper(IEmpDao.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean(name = "iDeptDao")
//    public IDeptDao CreateDeptDao(){
//        try {
//            InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory build = builder.build(in);
//            return build.openSession().getMapper(IDeptDao.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
