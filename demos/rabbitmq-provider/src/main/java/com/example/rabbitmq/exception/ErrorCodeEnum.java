package com.example.rabbitmq.exception;

import lombok.Data;

public enum ErrorCodeEnum {
    SYS_ERROR("SYS_ERROR", "系统错误"),
    UNKNOW_ERROR("UNKNOW_ERROR", "未知错误"),
    ILLEGAL("ILLEGAL", "参数校验错误");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ErrorCodeEnum getbyvalue(String code) {
        for (ErrorCodeEnum errorCodeEnum : values()) {
            if (errorCodeEnum.code.equals(code)) {
                return errorCodeEnum;
            }

        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
