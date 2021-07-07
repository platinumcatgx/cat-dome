package com.gx.dao;

import com.gx.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
