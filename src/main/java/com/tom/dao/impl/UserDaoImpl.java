package com.tom.dao.impl;

import com.tom.dao.UserDao;
import com.tom.entity.User;
import com.tom.util.BaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseUtil implements UserDao {
    @Override
    public int add(User user) {
        String sql = "insert into user(name, password, age, sex, email) VALUES (?,?,?,?,?)";
        return this.executeUpdate(sql,user.getName(),user.getPassword(),user.getAge(),
                user.getSex(),user.getEmail());
    }

    @Override
    public int update(User user) {
        String sql = "update user set name=?,password=? where id=?";
        return this.executeUpdate(sql,user.getName(),user.getPassword(),user.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from user where id=?";
        return this.executeUpdate(sql,id);
    }

    @Override
    public User UserById(Integer id) {
        User user = new User();
        String sql = "select * from user where id=?";
        ResultSet resultSet = this.executeQuery(sql, id);
        try {
            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getString("age"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> USER_LIST() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "select * from user";
        ResultSet resultSet = this.executeQuery(sql);
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getString("age"));
            user.setSex(resultSet.getString("sex"));
            user.setEmail(resultSet.getString("email"));
            list.add(user);
        }
        return list;
    }

    @Override
    public User login(User user) throws SQLException {
        String sql = "select * from user where name=? and password=?";
        ResultSet resultSet = this.executeQuery(sql, user.getName(), user.getPassword());
        user = new User();
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getString("age"));
            user.setSex(resultSet.getString("sex"));
            user.setEmail(resultSet.getString("email"));

        }
        return user;
    }
}
