package gx1.dao;

import gx1.domain.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    List<Dept> findAll();

//    写反了...
    List<Dept> findAllEmp();

}