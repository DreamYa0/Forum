package com.zbj.forum.service;

import com.zbj.forum.entity.User;

import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
public interface IUserService extends IBaseService<User>{

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user) throws Exception;

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    List<User> queryUserByUserName(String userName);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();

    /**
     * 用户登录
     * @param user
     */
    User login(User user);
}
