package com.zcx.sqlrecord.service;

import com.zcx.sqlrecord.entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
public interface UserService {
    boolean checkLogin(User user);
}
