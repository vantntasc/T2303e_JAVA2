package org.aptech.t2303e.session4.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.session3.db.User;
import org.aptech.t2303e.session4.consts.UserStatus;
import org.aptech.t2303e.session4.dao.UserDao;
import org.aptech.t2303e.session4.dao.impl.UserDaoImpl;
import org.aptech.t2303e.session4.service.UserService;
import org.aptech.t2303e.utils.encryptionutils.AESUtils;

public class UserServiceImpl implements UserService {
    private static final int MAX_LOGIN_FAIL = 5;
    UserDao userRepo  = new UserDaoImpl();
    @Override
    public boolean login(String username, String password) {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return false;
        //1. get user by username (username unique)
        //2. tính từ lần đăng nhập mới nhất , tối đa 5 lần đăng nhập thất bại
        //3. bổ sung trường login_fail , status (active , inactive)
        // 4. compare password -> true : login ok / not ok
        User u = userRepo.getByUsername(username);
        // compare password
        String encryptedPass = AESUtils.encrypt(password);
        if(u.getPassword().equals(encryptedPass)){
            if(u.getStatus() != UserStatus.ACTIVE.status) return false;
            return u.getLoginFail() < MAX_LOGIN_FAIL;
        } else {
            // login fail ->  todo update login_fail+1
            if(u.getLoginFail() +1 >= MAX_LOGIN_FAIL){
                // block user
                u.setLoginFail(u.getLoginFail() +1);
                u.setStatus(UserStatus.BLOCKED.status);
            } else {
                u.setLoginFail(u.getLoginFail() +1);
                // update with login fail + 1
            }
            userRepo.update(u);
        }
        return false;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.err.println(userService.login("john doe2" , "admin@123"));
    }
}
