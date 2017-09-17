package com.zcx.sqlrecord.service.impl;

import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.Database;
import com.zcx.sqlrecord.entity.Record;
import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.repository.DatabaseRepository;
import com.zcx.sqlrecord.repository.RecordRepository;
import com.zcx.sqlrecord.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.Objects;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private DatabaseRepository databaseRepository;

    @Override
    public ResultMap<String> createSql(int databaseId, int userId, String sql) {
        Database database = databaseRepository.findOne(databaseId);
        if(Objects.isNull(database)){
            throw new RuntimeException("database not fount");
        }
        executeSql(database,sql);

        return null;
    }

    private void executeSql(Database database, String sql) {

    }
}
