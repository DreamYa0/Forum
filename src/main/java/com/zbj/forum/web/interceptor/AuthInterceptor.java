package com.zbj.forum.web.interceptor;

import com.zbj.forum.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.zbj.forum.utils.UserContext.getLoginUser;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
    // 拦截页面请求路由地址
    private static final String LOGIN_PATH = "/login";
    private static final String LOGINPOST_PATH = "/loginPost";
    private static final String LOGOUT_PATH = "/logout";
    private static final String INDEX_PATH = "/index";
    private static final List<String> SCIENTIFIC_PATH = new ArrayList<>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception{

        String requestURI=request.getRequestURI();
        User user;
        if (!requestURI.equals(LOGIN_PATH) && !requestURI.equals(LOGINPOST_PATH) && !requestURI.equals(LOGOUT_PATH)) {
            user=getLoginUser();
            // 登录拦截
            if (user == null) {
                if (requestURI.equals(INDEX_PATH)) {
                    response.sendRedirect("/login");
                } else {
                    response.sendError(response.SC_UNAUTHORIZED,"用户没有登录!");
                }
                return false;
            }
            // 权限拦截,只有管理员才能访问下面的路由
            if (user.getUserType() != 2) {
                requestURI.contains("/user/delete");
                requestURI.contains("/user/getAllUsers");
            }
        }
        return true;
    }
}
