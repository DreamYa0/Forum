package com.zbj.forum.mapper;

import com.zbj.forum.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 用户注册
     * @param user
     * @return
     */
    void register(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 根据用户信息更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 根据用户名锁定用户
     * @param userName
     */
    void lockUser(String userName);

    /**
     * 根据用户名解锁用户
     * @param
     */
    void unlockUser(String username);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);
}
