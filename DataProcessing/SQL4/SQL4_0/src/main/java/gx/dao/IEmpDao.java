package gx.dao;

import gx.domain.Emp;

import java.util.List;

public interface IEmpDao {

//    @Select("select *from emp")
    List<Emp> findAll();

    List<Emp> findById(Integer deptno);

}
