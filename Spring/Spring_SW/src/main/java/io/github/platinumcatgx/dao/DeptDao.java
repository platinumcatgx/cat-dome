package io.github.platinumcatgx.dao;

import io.github.platinumcatgx.domain.Dept;

import java.util.List;

public interface DeptDao {

    List<Dept> findAll();

    Dept findById(Integer id);

    void Update(Dept dept);

    void Insert(Dept dept);

    void Delete(Dept dept);



}
