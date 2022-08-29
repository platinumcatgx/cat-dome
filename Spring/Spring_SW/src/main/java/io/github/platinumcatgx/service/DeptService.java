package io.github.platinumcatgx.service;

import io.github.platinumcatgx.domain.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    Dept findById(Integer id);

    void Update(Dept dept);

    void Insert(Dept dept);

    void Delete(Dept dept);

}
