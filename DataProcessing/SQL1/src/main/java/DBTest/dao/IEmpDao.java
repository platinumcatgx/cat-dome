package DBTest.dao;

import DBTest.domain.Dept1;
import DBTest.domain.Emp;
import DBTest.domain.Emp2;
import DBTest.domain.EmpDept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IEmpDao {

    @Select("select *from emp")
    List<Emp> findAll();

    Integer findMgr(String name);

    @Select("select * from emp where sal < (select sal from emp  where ename = #{name})")
    List<Emp> findMgrUp(String name);

    @Insert("insert into emp values(#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno});")
    int Save(Emp e);

    @Update("update emp set comm = #{comm} where sal = 800")
    int Update(int comm);

    @Delete("delete from emp where sal = #{sal}")
    int deleteOfSal(int sal);

    @Select("select * from emp where ename like '%${value}%' ")
    List<Emp> findEnameMoHu(String ename);

    @Select("select count(*) from emp")
    int findAllEmp();

    List<Emp2> findEmp2();

//    如果是刘一,则查询其他,否则查询刘一
    List<Emp> findEmps(Emp emp);

    //    如果是刘一,则查询其他,否则查询刘一
    List<Emp> findEmps2(Emp emp);

//    多对一
    @Select("select * from emp join dept on emp.deptno=dept.deptno ")
    List<EmpDept> findAllEmpDept();

//    多对一2
    List<Dept1> findAllEmp3();



}
