package gx.dao;

import gx.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IDeptDao {

    @Select("select * from dept")
    List<Dept> findAllDept();

    /**
     * 添加数据
     * @param dept
     * @return
     */
    @Insert("insert into dept values(#{deptno},#{dname},#{loc})")
    int Save(Dept dept);

//    /**
//     * 更新数据
//     * @param dept
//     * @return
//     */
//    @Update("UPDATE dept SET dname= #{dname} WHERE loc='武当山' ")
//    int Update(Dept dept);
//
//    /**
//     * 删除数据
//     * @param deptno
//     * @return
//     */
//    @Delete("delete from dept where deptno=#{deptno}")
//    int delete(int deptno);
//
//    /**
//     * 根据deptno查询部门
//     * @param deptno
//     * @return
//     */
//    @Select("select * from dept where deptno=#{deptno}")
//    Dept findOne(int deptno);


}
