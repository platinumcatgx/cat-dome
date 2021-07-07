package gx1.dao;


import gx1.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

}
