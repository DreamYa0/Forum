package com.zbj.forum.web.common;

import java.io.Serializable;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class CommonConstant implements Serializable {

    //四位数字
    public static final String FOUR_NUM = "^(\\d{2}|\\d{4})$";
    /**
     * 本地服务分布的id
     */
    public static final int CLIENT_ID = 10003;
    /**
     * 客户密码
     */
    public static final String CLIENT_SECRET = "e5ff9c94e14f29901b5e8e1db5279d89";
    /**
     * 普通用户
     */
    public static final Integer ORDINARY_USER = 1;
    /**
     * 管理员
     */
    public static final Integer MANAGE_USER = 2;
    /**
     * session里的用户KEY
     */
    public static final String USER_IN_SESSION = "userInSession";
    /**
     * session里的token
     */
    public static final String TOKEN_IN_SESSION = "tokenInSession";
}
