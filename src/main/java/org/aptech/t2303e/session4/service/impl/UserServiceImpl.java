package org.aptech.t2303e.session4.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.session4.dao.UserDao;
import org.aptech.t2303e.session4.dao.impl.UserDaoImpl;
import org.aptech.t2303e.session4.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userRepo  = new UserDaoImpl();
    @Override
    public boolean login(String username, String password) {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return false;
        // get user by username (username unique)
        // tính từ lần đăng nhập mới nhất , tối đa 5 lần đăng nhập thất bại
        // bổ sung trường login_fail , status (active , inactive)
        // compare password -> true : login ok / not ok
        return false;
    }
}
