package com.zbj.forum.web.common;

import java.io.Serializable;

/**
 * 服务响应体. 所有服务统一使用此数据结构作为服务响应体.
 *
 * @param <T>
 * @author DreamYao
 */
public class Result<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标识.
     */
    private static final int OK = 10000;

    /**
     * 错误码.
     * 定义错误码规则如下:
     * 10000: 代表成功
     * 错误码长度为5位数字, 第一位为4, 代表为调用方错误;
     * 第一位为5, 代表服务方错误.
     * 调用方错误：参数为空, 参数不符合规范, 等等.
     * 服务方错误：订单查询失败, 数据库无法连接, 服务内部异常, 等等.
     * 例如：
     * 40001：订单号为空
     * 40002：支付类型不匹配.
     * 50001：订单查询失败
     * 50002：SQL异常.
     */
    private int errorCode;

    /**
     * 错误描述信息. 简单描述服务具体错误的原因.
     * 当错误码 errorCode == 10000 时, 代表成功,
     * 此时errorMsg为默认的ok.
     * 错误码 errorCode != 10000 时, 代表失败,
     * 此时errorMsg由服务开发人员填充, 用以描述清楚具体的错误信息.
     * 此errorMsg不应作为前端提示信息, 而仅用于服务异常排查.
     * 前端提示信息应由业务方根据产品需求自定义.
     */
    private String errorMsg;

    /**
     * 具体的返回信息.
     * 当且仅当 errorCode == 10000时, 存在.
     */
    private T data;

    public Result() {
        this(OK, "ok");
    }

    public Result(T data) {
        this();
        this.data = data;
    }

    public Result(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    /**
     * 服务调用成功. 当为true时, 代表成功;
     * 当为false时, 代表失败.
     *
     * @return
     */
    public boolean isOk() {
        return errorCode == OK;
    }

    public Result<T> setErrorCode(final int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Result<T> setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}

