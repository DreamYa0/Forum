package com.zbj.forum.web.controller;

import com.zbj.forum.entity.User;
import com.zbj.forum.service.IUserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户注册
     *
     * @param param
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult save(@RequestBody String param) {
        try {
            JSONObject jsonObject = new JSONObject(param);
            String userName = jsonObject.get("userName").toString();
            String password = jsonObject.get("password").toString();
            try {
                if (jsonObject == null || userName == null || userName.equals("") || password == null || password.equals("")) {
                    return new CommonResult(false, CommonResult.USER_USERPWD_EMPTY, "用户或密码为空", null);
                }
                User queryUser = userService.getUserByUserName(userName);
                if (queryUser != null || queryUser.getUserName() != null) {
                    return new CommonResult(false, CommonResult.STATUS_FAILURE, "用户名已存在", null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(false, CommonResult.getStatusError(), "参数错误!", null);
        }
        return new CommonResult(true, CommonResult.STATUS_SUCCESS, "用户注册成功",null);
    }

    /**
     * 用户删除
     *
     * @param param {"userName":""}
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult deleteUser(@RequestBody String param, HttpSession session){
        Integer loginUserId;
        Integer deleteUserId;
        try {
            User user = (User) session.getAttribute("userInSession");
            loginUserId=user.getId();
            if (user == null) {
                return new CommonResult(false, CommonResult.NO_PERMISSION, "当前用户没有登录!", null);
            }
            Integer userType = user.getUserType();
            if (userType != 2) {
                return new CommonResult(false, CommonResult.getStatusError(), "此登录的用户没有删除用户权限", null);
            }
            JSONObject jsonObject = new JSONObject(param);
            String userName = jsonObject.get("userName").toString();
            try {
                User queryUser = userService.getUserByUserName(userName);
                deleteUserId=queryUser.getId();
                if (loginUserId == deleteUserId) {
                    return new CommonResult(false,CommonResult.STATUS_ERROR, "用户不能删除自己!", null);
                }
                userService.delete(deleteUserId);
            } catch (NullPointerException e) {
                return new CommonResult(false,CommonResult.getStatusError(),"删除的用户不存在!",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(false,CommonResult.getStatusError(),"getSessionFailed!",null);
        }
        return new CommonResult(true, CommonResult.STATUS_SUCCESS, "删除用户成功!", null);
    }
}
