package com.zcx.sqlrecord.service.impl;

import com.zcx.sqlrecord.entity.Record;
import com.zcx.sqlrecord.repository.RecordRepository;
import com.zcx.sqlrecord.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@Component
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Iterable<Record> queryAll(int dbId) {
        Iterable<Record> result = recordRepository.findAllByDbIdOrderByCreateTimeDesc(dbId);
        return result;

    }
}
