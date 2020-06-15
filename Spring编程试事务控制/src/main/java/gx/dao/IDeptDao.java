package gx.dao;

import gx.domain.Dept;

import java.util.List;

public interface IDeptDao {

    List<Dept> findAll(Integer id);

    void Update(Dept dept);

}
