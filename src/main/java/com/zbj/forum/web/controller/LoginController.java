package com.zbj.forum.web.controller;

import com.zbj.forum.entity.User;
import com.zbj.forum.service.IUserService;
import com.zbj.forum.web.common.CommonConstant;
import com.zbj.forum.web.common.CommonResult;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
     * @param param
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object loginPost(@RequestBody String param, HttpSession session) {
        JSONObject jsonObject = new JSONObject(param);
        String userName = jsonObject.get("userName").toString();
        String password = jsonObject.get("password").toString();
        try {
            User queryUser = userService.getUserByUserName(userName);
            if (queryUser != null || queryUser.getUserName() != null) {
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                try {
                    User u = userService.login(user);
                    if (u != null) {
                        session.setAttribute(CommonConstant.USER_IN_SESSION, u);
                    } else {
                        return new CommonResult("密码错误!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new CommonResult(CommonResult.getStatusError());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("用户名不存在!");
        }
        return new CommonResult(true, CommonResult.STATUS_SUCCESS,"登录成功!");
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
        user.setPassword(null);
        return new CommonResult(true, CommonResult.STATUS_SUCCESS,"获取用户信息成功!", user);
    }
}
