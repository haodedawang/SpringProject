package com.example.rabbitmq.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {
    private ErrorCodeEnum errorCode;

    public MyException(ErrorCodeEnum errorCode){
        super(errorCode.getDesc());
        this.setErrorCode(errorCode);
    }
}
