package com.zbj.forum.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class LoginLog implements Serializable {
    private static final long serialVersionUID = -7318278109743008657L;
    /**
     * 日志ID
     */
    private Integer id;

    /**
     * 发表者ID
     */
    private Integer userId;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * 登录时间
     */
    private Date loginDataTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDataTime() {
        return loginDataTime;
    }

    public void setLoginDataTime(Date loginDataTime) {
        this.loginDataTime = loginDataTime;
    }
}
