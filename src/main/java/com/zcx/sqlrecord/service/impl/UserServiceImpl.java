package com.zcx.sqlrecord.service.impl;

import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.repository.UserRepository;
import com.zcx.sqlrecord.service.UserService;
import com.zcx.sqlrecord.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkLogin(User user) {
        User dbUser = userRepository.findByAccount(user.getAccount());
        return dbUser.getPassword().equals(PasswordUtils.encrypt(user.getPassword()));
    }
}
