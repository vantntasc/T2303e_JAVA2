package org.aptech.t2303e.session4.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.session3.db.Datasource;
import org.aptech.t2303e.session3.db.User;
import org.aptech.t2303e.session4.dao.UserDao;

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

    public static void main(String[] args) {
        UserDaoImpl obj  = new UserDaoImpl();
        User u =  obj.getByUsername("Demo1");
        System.err.println(u);
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
