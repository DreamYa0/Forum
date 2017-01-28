package com.zbj.forum.utils;

import com.zbj.forum.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.zbj.forum.web.common.CommonConstant.MANAGE_USER;
import static com.zbj.forum.web.common.CommonConstant.ORDINARY_USER;
import static com.zbj.forum.web.common.CommonConstant.USER_IN_SESSION;

/**
 * Created by DreamYao on 2017/1/27.
 */
public class UserContext {

    /**
     * 从用户下文中取出请求信息
     * @return
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    /**
     * 从请求信息中取出Session
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    /**
     * 从Session中取出当前登录的用户信息
     * @return
     */
    public static User getLoginUser(){
        return (User) getSession().getAttribute(USER_IN_SESSION);
    }

    /**
     * 是否是普通用户
     * @return
     */
    public static Boolean isOrdinaryUser(){
        if (getLoginUser().getUserType() == ORDINARY_USER) {
            return true;
        } else if (getLoginUser().getUserType() == MANAGE_USER) {
            return false;
        } else {
            return null;
        }
    }
}
