package com.zbj.forum.web.controller;

import com.zbj.forum.entity.User;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.service.IUserService;
import com.zbj.forum.web.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import static com.zbj.forum.web.common.CommonConstant.CLIENT_SECRET;
import static com.zbj.forum.web.common.CommonConstant.USER_IN_SESSION;
import static com.zbj.forum.web.common.CommonResult.STATUS_SUCCESS;
import static com.zbj.forum.web.common.CommonResult.getStatusError;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object loginPost(@RequestBody User user, HttpSession session) {
        String userName = user.getUserName();
        try {
            User queryUser = userService.getUserByUserName(userName);
            if (queryUser != null || queryUser.getUserName() != null) {
                try {
                    User u = userService.login(user);
                    if (u != null) {
                        session.setAttribute(USER_IN_SESSION, u);
                    } else {
                        return new CommonResult("密码错误!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new CommonResult(getStatusError());
                }
            }
        } catch (CRUDException e) {
            e.printStackTrace();
            return new CommonResult("用户名不存在!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("系统异常!");
        }
        return new CommonResult(true, STATUS_SUCCESS,"登录成功!");
    }

    /**
     * 获取登录用户信息
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public CommonResult getLoginUser(HttpSession session) {
        User user;
        try {
            user = (User) session.getAttribute("userInSession");
            if (user == null) {
                return new CommonResult("当前用户没有登录!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("getSessionFailed!");
        }
        user.setPassword(CLIENT_SECRET);
        return new CommonResult(true, STATUS_SUCCESS,"获取用户信息成功!", user);
    }
}
