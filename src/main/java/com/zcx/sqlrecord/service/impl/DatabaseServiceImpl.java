package com.zcx.sqlrecord.service.impl;

import com.zcx.sqlrecord.dto.ResultMap;
import com.zcx.sqlrecord.entity.Database;
import com.zcx.sqlrecord.entity.Record;
import com.zcx.sqlrecord.enums.ExecuteStatusEnum;
import com.zcx.sqlrecord.repository.DatabaseRepository;
import com.zcx.sqlrecord.repository.RecordRepository;
import com.zcx.sqlrecord.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Objects;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
@Component
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private DatabaseRepository databaseRepository;

    @Override
    public ResultMap<String> executeSql(int databaseId, int userId, String sql) {
        Database database = databaseRepository.findOne(databaseId);
        if (Objects.isNull(database)) {
            throw new RuntimeException("database not fount");
        }
        ResultMap<String> result = new ResultMap<>();
        int resultCode;
        String resultMessage;
        Record record = Record.builder()
                .createTime(new Date())
                .sqlStatement(sql)
                .userId(userId)
                .build();
        String executeMessage;
        try {
            int updateCount = executeSql(database, sql);
            resultCode = ExecuteStatusEnum.SUCCESS.getCode();
            resultMessage = ExecuteStatusEnum.SUCCESS.getDesc();
            executeMessage = "update count:" + updateCount;
        } catch (SQLException e) {
            e.printStackTrace();
            resultCode = ExecuteStatusEnum.FAILURE.getCode();
            resultMessage = ExecuteStatusEnum.FAILURE.getDesc();
            executeMessage = e.getMessage();
        }
        record.setExecuteStatus(resultCode);
        record.setExecuteMessage(executeMessage);
        recordRepository.save(record);

        result.setCode(resultCode);
        result.setData(executeMessage);
        result.setMessage(resultMessage);

        return result;
    }

    @Override
    public Iterable<Database> queryAll() {
        Iterable<Database> all = databaseRepository.findAll();
        for (Database database : all) {
            database.setAccount("");
            database.setPassword("");
        }
        return all;
    }

    //  很怀疑这个事务能不能生效,因为下面这个函数是直接操作数据库的
    @Transactional
    private int executeSql(Database database, String sql) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database.getUrl(), database.getAccount(), database.getPassword());
            Statement statement = conn.createStatement();
            statement.execute(sql);
            return statement.getUpdateCount();
        } catch (Exception e) {
            // TODO: 2017/9/18 add log
            e.printStackTrace();
            throw e;
        } finally {
            if (Objects.nonNull(conn)) conn.close();
        }

    }


}
