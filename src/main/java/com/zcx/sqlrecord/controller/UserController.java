package com.zcx.sqlrecord.controller;

import com.zcx.sqlrecord.constant.SessionKeyConstants;
import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap login(@RequestBody User user, HttpSession httpSession) {
        boolean success = userService.checkLogin(user);
        if (success) httpSession.setAttribute(SessionKeyConstants.account, user.getAccount());
        return ResultMap.generate(success);
    }
}
