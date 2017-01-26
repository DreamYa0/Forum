package com.zbj.forum.service;

import com.zbj.forum.entity.User;
import com.zbj.forum.exception.CRUDException;

import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 更新用户信息
     *
     * @param user
     */
    void update(User user) throws Exception;

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User getUserByUserName(String userName) throws Exception;

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> getAllUsers() throws Exception;

    /**
     * 用户登录
     *
     * @param user
     */
    User login(User user);
}
