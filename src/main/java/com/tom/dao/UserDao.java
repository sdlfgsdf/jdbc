package com.tom.dao;

import com.tom.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //添加
    public int add(User user);
    //更新
    public int update(User user);
    //删除
    public int delete(Integer id);
    //查询单条
    User UserById(Integer id);
    //查询全部
    List<User> USER_LIST() throws SQLException;
    //登录
    User login(User user) throws SQLException;
}
