package DBTest.dao;

import DBTest.domain.Dept;
import DBTest.domain.Dept1;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    List<Dept> findAll();

    List<Dept1> findAllEmp();
}
