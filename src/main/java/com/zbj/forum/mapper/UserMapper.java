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
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User getUserByUserName(String userName);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getAllUsers();

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 更新积分
     * @param user
     */
    void updateCredit(User user);
}
