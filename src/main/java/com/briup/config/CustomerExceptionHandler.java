package com.briup.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.briup.utils.MessageUtil;
import com.briup.utils.Message;

/**
 * @program: app01
 * @description: 统一异常处理类
 **/
@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(value =  Exception.class) // 捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E> Message handler(Exception exception){
        exception.printStackTrace();
        return MessageUtil.error(exception.getMessage());
    }
}
