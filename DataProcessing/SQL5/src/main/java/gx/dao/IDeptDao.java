package gx.dao;

import gx.domain.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    List<Dept> findAll();

    @Insert("insert into dept values(#{deptno},#{dname},#{loc})")
    int Save(Dept dept);

    @Update("UPDATE dept SET dname= #{dname} WHERE loc='武当山' ")
    int Update(Dept dept);

    @Delete("delete from dept where deptno=#{deptno}")
    int delete(int deptno);

    @Select("select * from dept where deptno=#{deptno}")
    Dept findOne(int deptno);

    @Select("select * from dept where dname like #{dname}")
    List<Dept> findByEname(String dname);

    @Select("select count(*) from dept ")
    int findTota();


}
