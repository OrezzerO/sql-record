package com.zcx.sqlrecord.controller;

import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "login" ,method = RequestMethod.POST)
    public ResultMap login(@RequestBody User user) {
        boolean success = userService.checkLogin(user);
        return ResultMap.generate(success);
    }
}
