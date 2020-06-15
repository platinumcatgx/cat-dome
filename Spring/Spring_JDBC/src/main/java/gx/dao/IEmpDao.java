package gx.dao;

import gx.domain.emp;

/**
 * 账户的持久层接口
 */
public interface IEmpDao {

    emp findById(int id);

    emp findByName(String name);

    void updateEmp(emp emp);

}
