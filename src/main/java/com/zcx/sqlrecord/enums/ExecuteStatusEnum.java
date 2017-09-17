package com.zcx.sqlrecord.enums;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
public enum ExecuteStatusEnum {
    SUCCESS(200,"SUCCESS"),
    FAILURE(500,"FAILURE");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ExecuteStatusEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
