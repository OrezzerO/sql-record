package com.zcx.sqlrecord.controller;

import com.zcx.sqlrecord.context.ContextContainer;
import com.zcx.sqlrecord.context.UserContext;
import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.Record;
import com.zcx.sqlrecord.service.DatabaseService;
import com.zcx.sqlrecord.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@RestController
@RequestMapping("/sql")
public class SqlController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private DatabaseService databaseService;

    // TODO: 2017/9/18 paging
    @RequestMapping("/queryByDB")
    public ResultMap queryAll(@RequestBody Record record) {
        Iterable<Record> records = recordService.queryAll(record.getDbId());
        return ResultMap.addData(records);
    }

    @RequestMapping("/executeSql")
    public ResultMap executeSql(@RequestBody Record record){
        UserContext userContext = ContextContainer.getUserContext();
        return databaseService.executeSql(record.getDbId(),userContext.getUser().getId(),record.getSqlStatement());
    }
}
