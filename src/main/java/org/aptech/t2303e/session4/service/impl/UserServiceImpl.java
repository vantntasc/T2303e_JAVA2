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
        return userRepo.validateUser(username,password);
    }
}
