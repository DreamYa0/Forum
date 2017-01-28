package com.zbj.forum.exception;

/**
 * Created by dreamyao on 2017/1/27.
 */
public final class ExceptionCode {

    /**
     * 系统错误
     */
    public static final int SYSTEM_SUCCESS = 10000;
    /**
     * 系统错误
     */
    public static final int SYSTEM_ERROR = 11000;
    /**
     * 请求参数为空
     */
    public static final int ARGUMENT_IS_NULL = 11001;
    /**
     * 请求参数不合法
     */
    public static final int ARGUMENT_ILLEGAL = 11002;

    /**
     * 数据转换错误
     */
    public static final int DATA_CONVERT_ERROR = 11003;

    /**
     * 数据错误,selectOne,但是发现多余1条
     */
    public static final int DATA_MUTIL_ERROR = 11004;

    /**
     * 不支持此方法调用
     */
    public static final int METHOD_NOT_ALLOW = 11005;

    /**
     * 无对应的数据
     */
    public static final int HAVE_NOT_DATA = 11006;

    /**
     * 存在重复数据repeat
     */
    public static final int HAVE_REPEAT_DATA = 11007;
}
