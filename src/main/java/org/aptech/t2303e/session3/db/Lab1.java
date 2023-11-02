package org.aptech.t2303e.session3.db;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lab1 {
//    public static  Connection connectDb(){
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, username, password);
//            System.err.println(connection != null ? "connect ok"
//                    : "Connect error");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return connection;
//    }
    // get all user from db -> map to list user in program
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        // 1 : statementt
        try {
            String sql  = "Select * from user_table";
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User u = rowMapper(rs);
                if(!Objects.isNull(u)) users.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return  users;
    }
    private  static User rowMapper(ResultSet rs){
        User u = null;
        int id  = 0;
        try {
            id = rs.getInt("id");
            String username  = rs.getString("username");
            String pass = rs.getString("password");
            u = User.builder()
                    .id(id)
                    .username(username)
                    .password(pass)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }
    public static boolean validateUser(String username ,String password){
        boolean result = false;
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) return result;
        String sql  = "Select * from user_table where username = "+"'"+username +"' "
                +" and password = '"+ password+"';";
        System.err.println(sql);
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        // 1 : statementt
        try {
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User u = rowMapper(rs);
                if(!Objects.isNull(u)) users.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        users.forEach(System.err::println);
        if(users != null && users.size() > 0){
            result = true;
        }
        return result;
    }
    public static boolean validateUser1(String username ,String password){
        boolean result = false;
        PreparedStatement preSt;
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) return result;
        String sql  = "Select * from user_table where username = ? and password = ?";
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        // 2 : prepaidStatementt
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, "'"+username+"'");
            preSt.setString(2,"'"+ password+"'");
            System.out.println(preSt);
            ResultSet rs = preSt.executeQuery();
            while (rs.next()){
                User u = rowMapper(rs);
                if(!Objects.isNull(u)) users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        users.forEach(System.err::println);
        if(users != null && users.size() > 0){
            result = true;
        }
        return result;
    }
    public static void main(String[] args) {
        // sql injection
//        boolean isOk  = validateUser1("Tao ko biet","Tao ko biet'\n" +
//                "or 'Biet hay ko cung ok' = 'Biet hay ko cung ok");
//        boolean isOk  = validateUser(null , null);
        boolean isOk  = validateUser1("Demo1" , "Demo1");
        System.err.println(isOk ? "Login success" : "Login failed");
    }
}
