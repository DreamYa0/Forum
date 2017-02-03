package com.zbj.forum.web.interceptor;

import com.zbj.forum.entity.User;
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

    private static final String LOGIN_PATH = "/login";
    private static final String LOGOUT_PATH = "/logout";
    private static final String INDEX_PATH = "/index";
    private static final String REGISTER_PATH = "/user/save";

    private static final List<String> PERMISSIONS_PATH = new ArrayList<>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String requestURI = request.getRequestURI();
        User user = getLoginUser();
        // 放行路由地址
        if (!requestURI.equals(LOGIN_PATH) && !requestURI.equals(LOGOUT_PATH) && !requestURI.equals(REGISTER_PATH)) {
            // 登录拦截
            if (user == null) {
                if (requestURI.equals(INDEX_PATH)) {
                    response.sendRedirect("/login");
                } else {
                    response.sendError(response.SC_UNAUTHORIZED, "用户没有登录!");
                }
                return false;
            }
            addPermissionsPath();
            // 拦截路由地址
            if (PERMISSIONS_PATH.contains(requestURI)) {
                // 权限拦截,只有管理员才能访问下面的路由
                if (user.getUserType() != MANAGE_USER) {
                    response.sendError(response.SC_UNAUTHORIZED, "登录的用户没有此权限!");
                }
            }
        }
        return true;
    }
    // 权限拦截路由地址
    private static void addPermissionsPath() {
        PERMISSIONS_PATH.add("/user/save");
        PERMISSIONS_PATH.add("/user/delete");
        PERMISSIONS_PATH.add("/user/update");
        PERMISSIONS_PATH.add("/user/getAllUsers");
        PERMISSIONS_PATH.add("/board/createBoard");
        PERMISSIONS_PATH.add("/board/getBoardMessage");
    }
}
