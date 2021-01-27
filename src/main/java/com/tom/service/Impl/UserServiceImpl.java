package com.tom.service.Impl;

import com.tom.dao.UserDao;
import com.tom.dao.impl.UserDaoImpl;
import com.tom.entity.User;
import com.tom.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public User UserById(Integer id) {
        return dao.UserById(id);
    }

    @Override
    public List<User> USER_LIST() throws SQLException {
        return dao.USER_LIST();
    }

    @Override
    public User login(User user) throws SQLException {
        return dao.login(user);
    }
}
