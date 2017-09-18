package com.zcx.sqlrecord.context;

import com.zcx.sqlrecord.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangchengxi on 2017/9/18.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserContext {
    private User user;
}
