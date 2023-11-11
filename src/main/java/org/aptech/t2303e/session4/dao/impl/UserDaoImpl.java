package org.aptech.t2303e.session4.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.session3.db.Datasource;
import org.aptech.t2303e.session3.db.User;
import org.aptech.t2303e.session4.dao.UserDao;
import org.aptech.t2303e.session4.service.UserService;
import org.aptech.t2303e.session4.service.impl.UserServiceImpl;
import org.aptech.t2303e.utils.encryptionutils.AESUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean validateUser(String username, String password) {
        boolean result = false;
        PreparedStatement preSt;
        String sql  = "Select * from user_table where username = ? and password = ?";
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        // 2 : prepaidStatementt
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, username);
            preSt.setString(2,password);
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
        if(users != null && users.size() > 0){
            result = true;
        }
        return result;
    }

    @Override
    public User getByUsername(String username) {
        PreparedStatement preSt;
        String sql  = "Select * from user_table where username = ?";
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, username);
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
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public Boolean insert(User u) {
        PreparedStatement preSt;
        String sql  = "Insert into user_table(username,password,created_at,updated_at)" +
                " values(? , ? , ? ,?)";
        Connection conn = Datasource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, u.getUsername());
            preSt.setString(2, u.getPassword());
            preSt.setDate(3, new java.sql.Date(u.getCreatedAt().getTime()));
            preSt.setDate(4, new java.sql.Date(u.getUpdatedAt().getTime()));
            preSt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(User u) {
        PreparedStatement preSt;
        String sql  = "Update user_table" +
                " set password = ? , login_fail = ? , status  = ? " +
                " , updated_at  = ? where username  = ?;";
        Connection conn = Datasource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, u.getPassword());
            preSt.setInt(2, u.getLoginFail());
            preSt.setInt(3, u.getStatus());
            preSt.setDate(4, new java.sql.Date(System.currentTimeMillis()));
            preSt.setString(5, u.getUsername());
            preSt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll(int limit, int offset) {
        long startTime  = System.currentTimeMillis();
        PreparedStatement preSt;
        String sql  = "Select * from user_table order by id limit ? offset  ? ";
        List<User> users = new ArrayList<>();
        Connection conn = Datasource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setInt(1, limit);
            preSt.setInt(2, offset);
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
        System.out.println("Process query find all , time executed : "+ (System.currentTimeMillis() - startTime) + " ms");
        return users;
    }

    @Override
    public Integer count(String sql) {
        Connection connection = Datasource.getConn();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao obj = new UserDaoImpl();
        UserService userService = new UserServiceImpl();
//        boolean result = obj.insert(User.builder()
//                .username("john doe2")
//                .password(AESUtils.encrypt("admin@123"))
//                .createdAt(new Date())
//                .updatedAt(new Date())
//                .build()
//        );
//        if (result) System.err.println("insert success");
        long startTime  = System.currentTimeMillis();
        int count  = obj.count("Select count(*) from user_table;");
        int limit  = 1000;
        int num = count / limit ;
        if(count % limit != 0) num++;
        String fileName  = "./etc/user_table.txt";
        for (int i = 0; i < num; i++) {
            List<User> users = obj.findAll(limit, i * limit);
            userService.insertFile(users,fileName);
        }
        System.out.println("Processing time  :"+(System.currentTimeMillis() - startTime)/1000 + " ms");
    }

    private  static User rowMapper(ResultSet rs){
        User u = null;
        int id  = 0;
        try {
            id = rs.getInt("id");
            String username  = rs.getString("username");
            String pass = rs.getString("password");
            int loginFail = rs.getInt("login_fail");
            int status  = rs.getInt("status");
            String createdBy = rs.getString("created_by");
            String updatedBy = rs.getString("updated_by");
            Date createdTime = rs.getDate("created_at");
            Date updatedTime = rs.getDate("updated_at");
            u = User.builder()
                    .id(id)
                    .username(username)
                    .password(pass)
                    .status(status)
                    .loginFail(loginFail)
                    .createdBy(createdBy)
                    .createdAt(createdTime)
                    .updatedBy(updatedBy)
                    .updatedAt(updatedTime)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }
}
