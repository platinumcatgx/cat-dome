package gx.dao;

import gx.domain.Dept;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    @Results(id = "deptMap" , value={
            @Result(id = true , column = "deptno" , property = "deptno"),
            @Result(column = "dname" ,property = "dname"),
            @Result(column = "loc" ,property = "loc"),
            @Result(property = "emps" , column = "deptno" ,
                    many = @Many(select = "gx.dao.IEmpDao.findByID",
                            fetchType= FetchType.LAZY))
    })
    List<Dept> findAll();
/*
    @Insert("insert into dept values(#{deptno},#{dname},#{loc})")
    int Save(Dept dept);

    @Update("UPDATE dept SET dname= #{dname} WHERE loc='武当山' ")
    int Update(Dept dept);

    @Delete("delete from dept where deptno=#{deptno}")
    int delete(int deptno);
*/
    @Select("select * from dept where deptno=#{deptno}")
//    @ResultMap("deptMap")
    Dept findOne(int deptno);

    @Select("select * from dept where dname like #{dname}")
    List<Dept> findByEname(String dname);

    @Select("select count(*) from dept ")
    int findTota();


}
