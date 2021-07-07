package DBTest.dao;

import DBTest.domain.Emp;
import DBTest.domain.QueryVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IQueryVo {

    @Select("select * from emp where ename like #{emp.ename} ")
    List<Emp> findMu(QueryVo queryVo);

//    动态查询 之 foreach
    List<Emp> findInIds(QueryVo vo);

}
