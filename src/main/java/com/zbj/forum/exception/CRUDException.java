package com.zbj.forum.exception;

/**
 * Created by dreamyao on 2017/1/26.
 */
public class CRUDException extends RuntimeException {

    /*增删改查异常的标志，设置为那一种异常*/
    public Integer code;
    public String message;

    public CRUDException(Integer code) {
        this.code=code;
    }

    public CRUDException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
