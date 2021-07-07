package gx.dao;

import gx.domain.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmpDao {
    @Select("select * from emp")
    List<Emp> findAll();

    @Insert("insert into emp values('0',)")
    int SaveEmp(Emp emp);

    @Update("undate from emp ename='刘一二' where ename = '刘一'")
    int Update(Emp emp);
}
