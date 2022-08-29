package gx.dao;

import gx.domain.Emp;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@CacheNamespace(blocking = true)//开启二级缓存
public interface IEmpDao {

    /**
     * 查询所有员工
     * @return
     */
    @Select("select * from emp")
    List<Emp> findAllEmp();

    /**
     * 根据deptno查询员工
     * @param deptno
     * @return
     */
    @Select("select * from emp where deptno=#{deptno}")
    List<Emp> findByID(Integer deptno);


}
