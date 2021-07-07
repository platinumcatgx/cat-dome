package gx.dao;

import gx.domain.City;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICityDao {

    @Select("select * from city")
    List<City> findAll();
}
