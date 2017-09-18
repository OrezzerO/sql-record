package com.zcx.sqlrecord.service;

import com.zcx.sqlrecord.entity.Record;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
public interface RecordService {
    Iterable<Record> queryAll(int dbId);
}
