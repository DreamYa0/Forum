package com.zbj.forum.web.controller;

import com.zbj.forum.entity.User;
import com.zbj.forum.exception.CRUDException;
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
import java.util.List;

import static com.zbj.forum.utils.CheckDataUtil.updateUserCheck;
import static com.zbj.forum.web.common.CommonConstant.CLIENT_SECRET;
import static com.zbj.forum.web.common.CommonConstant.MANAGE_USER;
import static com.zbj.forum.web.common.CommonResult.STATUS_SUCCESS;
import static com.zbj.forum.web.common.CommonResult.USER_USERPWD_EMPTY;

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
     * @param user
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult save(@RequestBody User user) {
        try {
            String userName = user.getUserName();
            String password = user.getPassword();
            try {
                if (user == null || userName == null || userName.equals("") || password == null || password.equals("")) {
                    return new CommonResult(false, USER_USERPWD_EMPTY, "用户或密码为空");
                }
                User queryUser = userService.getUserByUserName(userName);
                if (queryUser != null || queryUser.getUserName() != null) {
                    return new CommonResult("用户名已存在");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("参数错误!");
        }
        return new CommonResult(STATUS_SUCCESS, "用户注册成功");
    }

    /**
     * 用户删除
     *
     * @param user {"userName":""}
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult deleteUser(@RequestBody User user, HttpSession session) {
        Integer loginUserId;
        Integer deleteUserId;
        try {
            User loginUser = (User) session.getAttribute("userInSession");
            loginUserId = loginUser.getId();
            if (loginUser == null) {
                return new CommonResult("当前用户没有登录!");
            }
            Integer userType = loginUser.getUserType();
            if (userType != MANAGE_USER) {
                return new CommonResult("此登录的用户没有删除用户权限");
            }
            String userName = user.getUserName();
            try {
                User queryUser = userService.getUserByUserName(userName);
                deleteUserId = queryUser.getId();
                if (loginUserId == deleteUserId) {
                    return new CommonResult("用户不能删除自己!");
                }
                userService.delete(deleteUserId);
            } catch (NullPointerException e) {
                return new CommonResult("删除的用户不存在!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("getSessionFailed!");
        }
        return new CommonResult(STATUS_SUCCESS, "删除用户成功!");
    }

    /**
     * 用户信息更新(包括密码修好、用户锁定、用户解锁)
     *
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult updateUser(@RequestBody User user, HttpSession session) {
        try {
            User loginUser = (User) session.getAttribute("userInSession");
            if (loginUser.getUserType() != MANAGE_USER) {
                return new CommonResult("当前用户没有更新用户权限!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("请先登录!");
        }
        if (!updateUserCheck(user)) {
            return new CommonResult("参数错误!");
        }
        try {
            userService.update(user);
        } catch (CRUDException e) {
            e.printStackTrace();
            return new CommonResult("更新的用户不存在!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("系统错误!");
        }
        return new CommonResult(true, CommonResult.getStatusSuccess(), "用户更新成功!");
    }

    /**
     * 查询所有用户信息
     * 分页功能待实现
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public CommonResult getAllUsers(HttpSession session){
        try {
            User loginUser = (User) session.getAttribute("userInSession");
            if (loginUser.getUserType() != MANAGE_USER) {
                return new CommonResult("当前用户没有获取所有用户信息权限!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("请先登录!");
        }
        List<User> users;
        try {
            users = userService.getAllUsers();
            for (User user : users) {
                user.setPassword(CLIENT_SECRET);
            }
        } catch (CRUDException e) {
            e.printStackTrace();
            return new CommonResult("数据库中没有用户!");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("服务异常!");
        }
        return new CommonResult(users);
    }
}
