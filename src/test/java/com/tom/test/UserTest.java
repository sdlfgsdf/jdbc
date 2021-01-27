package com.tom.test;

import com.tom.entity.User;
import com.tom.service.Impl.UserServiceImpl;
import com.tom.service.UserService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserTest {
    @Test
    public void add(){
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("赵静怡1");
        user.setPassword("123456");
        user.setAge("22");
        user.setSex("女");
        user.setEmail("123@qq.com");
        int add = userService.add(user);
        if (add>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
    @Test
    public void update(){
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("赵静怡");
        user.setPassword("12345678");
        user.setId(27);
        int update = userService.update(user);
        if (update>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }
    @Test
    public void delete(){
        UserService userService = new UserServiceImpl();
        int delete = userService.delete(27);
        if (delete>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
    @Test
    public void listUserById(){
        UserService userService = new UserServiceImpl();
        User user = userService.UserById(26);
        System.out.println(user);
    }
    @Test
    public void UserAll() throws SQLException {
        UserService userService = new UserServiceImpl();
        List<User> list = userService.USER_LIST();
        for (User user:list){
            System.out.println(user);
        }

    }
    @Test
    public void login() throws SQLException {
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName("赵登选");
        user.setPassword("123456");
        User login = userService.login(user);
        if (login.getId()!=null){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
