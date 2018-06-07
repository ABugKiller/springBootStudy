package com.ad.springBoot.error;

/**
 * 自定义异常，用来实验捕获该异常
 */
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}
