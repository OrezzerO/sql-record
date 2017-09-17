package com.zcx.sqlrecord.service;

import com.zcx.sqlrecord.dto.ResultMap;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
public interface DatabaseService {
    ResultMap<String> executeSql(int databaseId, int userId, String sql);
}
