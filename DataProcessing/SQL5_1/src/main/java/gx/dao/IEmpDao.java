package gx.dao;

import gx.domain.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
//开启二级缓存
@CacheNamespace(blocking = true)
public interface IEmpDao {
    @Select("select * from emp")
    @Results(id = "empMap",value = {
            @Result(id = true,column = "empno",property = "empno"),
            @Result(column = "ename",property = "ename"),
            @Result(column = "job",property = "job"),
            @Result(column = "mgr",property = "mgr"),
            @Result(column = "hiredate",property = "hiredate"),
            @Result(column = "sal",property = "sal"),
            @Result(column = "comm",property = "comm"),
            @Result(column = "deptno" ,property = "deptno"),
            @Result(property = "dept",column = "deptno",
                    one = @One(select = "gx.dao.IDeptDao.findOne",fetchType = FetchType.LAZY))
    })
    List<Emp> findAll();

    @Select("select * from emp where deptno=#{deptno}")
    List<Emp> findByID(Integer deptno);
}
