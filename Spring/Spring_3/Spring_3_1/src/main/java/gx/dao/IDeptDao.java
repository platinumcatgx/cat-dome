package gx.dao;

import gx.domain.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 数据库相关的操作
 */
public interface IDeptDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from dept")
    List<Dept> findAllDept();

}
