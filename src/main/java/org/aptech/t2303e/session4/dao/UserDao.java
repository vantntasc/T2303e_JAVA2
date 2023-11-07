package org.aptech.t2303e.session4.dao;

public interface UserDao {
    // dao  : tương tác với dbs
    boolean validateUser(String username, String password);
}
