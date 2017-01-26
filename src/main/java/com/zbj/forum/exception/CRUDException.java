package com.zbj.forum.exception;

/**
 * Created by dreamyao on 2017/1/26.
 */
public class CRUDException extends RuntimeException {

    /*增删改查异常的标志，设置为那一种异常*/
    public String flag;
    public String message;

    public static final String SAVE_EXCEPTION = "saveException";
    public static final String UPDATE_EXCEPTION = "updateException";
    public static final String DELETE_EXCEPTION = "deleteException";
    public static final String FIND_EXCEPTION = "findException";

    public CRUDException() {
    }

    public CRUDException(String flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
