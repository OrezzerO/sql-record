package com.zcx.sqlrecord.repository;

import com.zcx.sqlrecord.entity.Record;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
public interface RecordRepository extends CrudRepository<Record, Integer> {

}
