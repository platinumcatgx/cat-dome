package gx.ser;

import gx.domain.Dept;

import java.util.List;

public interface IDeptSer {

    List<Dept> findAll(Integer id);

    void Update(Dept dept);

}
