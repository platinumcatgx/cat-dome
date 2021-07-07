package gx.dao;

import gx.domain.Dept;

import java.util.List;

public interface IDeptDao {

//    @Select("select * from dept")
    List<Dept> findAll();
//    延迟加载,一对多
    List<Dept> find2();

}
