package gx1.dao;

import gx1.domain.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IEmpDao {

    @Select("select * from emp")
    List<Emp> findAll();

//    写反了...
    List<Emp> findAllEmp();

}
