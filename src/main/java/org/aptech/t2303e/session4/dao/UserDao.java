package org.aptech.t2303e.session4.dao;

import org.aptech.t2303e.session3.db.User;

public interface UserDao {
    // dao  : tương tác với dbs
    boolean validateUser(String username, String password);
    User getByUsername(String username);
}
