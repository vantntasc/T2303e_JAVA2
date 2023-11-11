package org.aptech.t2303e.session4.dao;

import org.aptech.t2303e.session3.db.User;

import java.util.List;

public interface UserDao {
    // dao  : tương tác với dbs
    boolean validateUser(String username, String password);
    User getByUsername(String username);
    Boolean insert(User u);
    Boolean update(User u);
    List<User> findAll(int limit, int offset);
    Integer count(String sql);
}
