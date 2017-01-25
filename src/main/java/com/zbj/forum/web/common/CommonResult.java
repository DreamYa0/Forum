package com.zbj.forum.web.common;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class CommonResult {

    /**
     * 错误
     */
    public static final Integer STATUS_ERROR = -1;
    /**
     * 失败
     */
    public static final Integer STATUS_FAILURE = 0;
    /**
     * 正常
     */
    public static final Integer STATUS_SUCCESS = 1;
    /**
     * 用户名为空
     */
    public static final Integer USER_USERNAME_EMPTY = 4001;
    /**
     * 用户密码为空
     */
    public static final Integer USER_USERPWD_EMPTY = 4002;
    /**
     * 用户密码位数不对
     */
    public static final Integer USER_USERPWD_LENGTH_ERR = 4003;
    /**
     * 登陆失败
     */
    public static final Integer USER_USERLOGIN_ERROR = 4004;
    /**
     * 登陆成功
     */
    public static final Integer USER_USERLOGIN_SUCCESS = 4005;
    /**
     * 参数错误
     */
    public static final Integer PARAMETER_ERROR = 5001;

    /**
     * 没有用户,没有登录
     */
    public static final Integer NO_PERMISSION = -2;
    /**
     * 返回的状态
     */
    private boolean status;
    /**
     * 返回信息码
     */
    private Integer code;
    /**
     * 返回提示信息
     */
    private String message;
    /**
     * 正确返回数据
     */
    private Object data;

    /**
     * 自定义返回信息
     *
     * @param status 是否成功
     * @param code
     * @param data
     */
    public CommonResult(boolean status, Integer code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 失败,不返回数据,返回错误码
     *
     * @param code
     */
    public CommonResult(Integer code) {
        this.status = false;
        this.code = code;
        this.data = null;
    }

    /**
     * 成功直接返回数据
     *
     * @param data
     */
    public CommonResult(Object data) {
        this.status = true;
        this.code = CommonResult.STATUS_SUCCESS;
        this.data = data;
    }

    public CommonResult() {

    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "status=" + status +
                ", code=" + code +
                ", message=" + message +
                ", data=" + data +
                '}';
    }

    public static Integer getStatusError() {
        return STATUS_ERROR;
    }

    public static Integer getStatusFailure() {
        return STATUS_FAILURE;
    }

    public static Integer getStatusSuccess() {
        return STATUS_SUCCESS;
    }

    public static Integer getUserUsernameEmpty() {
        return USER_USERNAME_EMPTY;
    }

    public static Integer getUserUserpwdEmpty() {
        return USER_USERPWD_EMPTY;
    }

    public static Integer getUserUserpwdLengthErr() {
        return USER_USERPWD_LENGTH_ERR;
    }

    public static Integer getUserUserloginError() {
        return USER_USERLOGIN_ERROR;
    }

    public static Integer getUserUserloginSuccess() {
        return USER_USERLOGIN_SUCCESS;
    }

    public static Integer getParameterError() {
        return PARAMETER_ERROR;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer message) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
