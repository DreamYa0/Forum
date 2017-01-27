package com.zbj.forum.exception;

/**
 * Created by dreamyao on 2017/1/26.
 */
public class CRUDException extends RuntimeException {

    /*增删改查异常的标志，设置为那一种异常*/
    public ErrorCode code;
    public String message;

    public CRUDException(ErrorCode code) {
        this.code=code;
    }

    public CRUDException(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
