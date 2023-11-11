package org.aptech.t2303e.session4.service;

import org.aptech.t2303e.session3.db.User;

import java.util.List;

public interface UserService {
    // service  : xử lý nghiệp vụ
    boolean login(String username , String password);
    void insertFile(List<User> users, String fileName);
}
