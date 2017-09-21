package com.zcx.sqlrecord.controller;

import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.Database;
import com.zcx.sqlrecord.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangchengxi on 2017/9/22.
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {
    @Autowired
    private DatabaseService databaseService;

    @RequestMapping("/queryAll")
    public ResultMap queryAll(){
        Iterable<Database> databases = databaseService.queryAll();
        return ResultMap.addData(databases);
    }
}
