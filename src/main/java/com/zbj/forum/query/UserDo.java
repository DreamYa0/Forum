package com.zbj.forum.query;

import java.io.Serializable;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class UserDo implements Serializable{
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
