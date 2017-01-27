package com.zbj.forum.web.interceptor;

import com.zbj.forum.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.zbj.forum.utils.UserContext.getLoginUser;
import static com.zbj.forum.web.common.CommonConstant.MANAGE_USER;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    // 拦截页面请求路由地址
    private static final String LOGIN_PATH = "/login";
    private static final String LOGOUT_PATH = "/logout";
    private static final String INDEX_PATH = "/index";
    private static final String REGISTER_PATH = "/user/save";
    private static final String DELETE_PATH = "/user/delete";
    private static final String GETALLUSER_PATH = "/user/getAllUsers";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String requestURI = request.getRequestURI();
        User user = getLoginUser();
        if (!requestURI.equals(LOGIN_PATH) && !requestURI.equals(LOGOUT_PATH) && !requestURI.equals(REGISTER_PATH)) {
            // 登录拦截
            if (user == null) {
                if (requestURI.equals(INDEX_PATH)) {
                    response.sendRedirect("/login");
                } else {
                    response.sendError(response.SC_UNAUTHORIZED, "用户没有登录!");
                }
                return false;
            } else if (requestURI.equals(DELETE_PATH) || requestURI.equals(GETALLUSER_PATH)) {
                // 权限拦截,只有管理员才能访问下面的路由
                if (user.getUserType() != MANAGE_USER) {
                    response.sendError(response.SC_UNAUTHORIZED, "登录的用户没有此权限!");
                }
            }
        }
        return true;
    }
}
