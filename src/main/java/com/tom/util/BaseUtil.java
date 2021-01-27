package com.tom.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseUtil {
    static String driver;
    static String url;
    static String username;
    static String password;
    static Connection connection;
    static PreparedStatement ps;
    static ResultSet rs;

    public static void init(){
        InputStream in = BaseUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static {
        init();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql,Object ...objs){
        getConnection();
        try{
            ps=connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
            return ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public ResultSet executeQuery(String sql,Object ...objs){
        getConnection();
        try{
            ps=connection.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1,objs[i]);
            }
            return ps.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void getConnection(){
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void close(){
        try{
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
