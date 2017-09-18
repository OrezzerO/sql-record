package com.zcx.sqlrecord.dto;

/**
 * Created by zhangchengxi on 2017/9/17.
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultMap<T> {
    private static final int SUCCESS_CODE = 200;
    private static final int FAILURE_CODE = 500;
    private int code;
    private String message;
    private T data;

    public static ResultMap generate(boolean isSuccess){
        int code = isSuccess? SUCCESS_CODE : FAILURE_CODE;
        return ResultMap.builder().code(code).build();
    }
}
