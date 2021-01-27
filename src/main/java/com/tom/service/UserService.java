package com.tom.service;

import com.tom.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    int add(User user);
    int update(User user);
    int delete(Integer id);
    User UserById(Integer id);
    List<User> USER_LIST() throws SQLException;
    User login(User user) throws SQLException;
}
