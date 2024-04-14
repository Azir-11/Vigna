package com.vigna.common.utils;

import com.vigna.common.exception.GlobalException;
import com.vigna.common.exception.GlobalExceptionMap;

/**
 * description: 全局异常抛出
 */
public class ExceptionUtil {

    private ExceptionUtil() {}

    /**
     * 抛异常
     */
    public static void throwEx(GlobalExceptionMap globalExceptionMap) {
        throw new GlobalException(globalExceptionMap, true);
    }

    /**
     * 抛异常
     */
    public static void throwEx(int code, String message) {
        throw new GlobalException(code, message);
    }

    /**
     * 抛异常到异常页面
     */
    public static void throwExToPage(GlobalExceptionMap globalExceptionMap) {
        throw new GlobalException(globalExceptionMap, false);
    }

}