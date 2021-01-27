package com.tom.test;

import com.tom.entity.User;
import com.tom.service.Impl.UserServiceImpl;
import com.tom.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String password = scanner.next();
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        User login = userService.login(user);
        if (login.getId()!=null){
            List<User> list = userService.USER_LIST();
            for (User user1 : list) {
                System.out.println(user1);
            }
        }else {
            System.err.println("用户名或密码输入错误");
        }
    }
}
