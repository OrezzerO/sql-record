package com.zcx.sqlrecord.service;

import com.alibaba.fastjson.JSON;
import com.zcx.sqlrecord.dto.ResultMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseServiceTest {

    @Autowired
    private DatabaseService databaseService;

    @Test
    public void testExecuteSql() throws Exception {
        int dbId = 1;
        int userId = 1;
        String sql = "INSERT INTO t_user (account,password)VALUE ('hehehe','123')";
        ResultMap<String> resultMap = databaseService.executeSql(dbId, userId, sql);
        System.out.println(JSON.toJSONString(resultMap));
    }
}
