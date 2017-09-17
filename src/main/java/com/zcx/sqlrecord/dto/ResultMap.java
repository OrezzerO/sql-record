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
    private int code;
    private String message;
    private T data;
}
