package com.zcx.sqlrecord.repository;

import com.zcx.sqlrecord.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
public interface UserRepository extends CrudRepository<User,Integer> {

    User findByAccount(String account);
}
