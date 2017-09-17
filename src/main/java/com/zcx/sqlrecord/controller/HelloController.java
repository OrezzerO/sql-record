package com.zcx.sqlrecord.controller;

import com.alibaba.fastjson.JSON;
import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.repository.UserRepository;
import com.zcx.sqlrecord.util.SpringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
@RestController("/")
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("hello")
    public String hello() {
        ApplicationContext applicationContext = SpringHelper.getApplicationContext();

        User user = userRepository.findOne(1);

        return JSON.toJSONString(user);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver ="com.mysql.jdbc.Driver";
        String url ="jdbc:mysql://localhost:3306/record";
        String user = "root";
        String password ="qwer1234";


        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);

        // statement用来执行SQL语句
        Statement statement =conn.createStatement();

        String sql = "insert INTO t_user (account,password)VALUE ('hehehe','123');";
        boolean success = statement.execute(sql);

//        while(rs.next()) {
//            System.out.println(rs.getString("id")+ "\t" + rs.getString("account"));
//        }
//        conn.close();
        System.out.println(success);
    }


}
