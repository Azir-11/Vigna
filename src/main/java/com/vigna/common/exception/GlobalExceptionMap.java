package com.vigna.common.exception;

public interface GlobalExceptionMap {

    /**
     * 返回 code
     */
    int getCode();

    /**
     * 返回消息
     */
    String getMessage();
}