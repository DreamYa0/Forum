package com.zbj.forum.service.impl;

import com.zbj.forum.entity.User;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.mapper.LoginLogMapper;
import com.zbj.forum.mapper.UserMapper;
import com.zbj.forum.query.BaseQuery;
import com.zbj.forum.query.PageList;
import com.zbj.forum.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginLogMapper loginLogMapper;

    /**
     * 用户注册
     *
     * @param user
     */
    @Override
    public void save(User user) {
        user.setLastVisit(new Date());
        userMapper.register(user);

    }

    /**
     * 用户删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) throws Exception {
        User user = this.get(id);
        if (user != null) {
            userMapper.delete(id);
        } else {
            throw new Exception();
        }

    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param id t_user表主键Id
     * @return
     */
    @Override
    public User get(Integer id) throws NullPointerException{
        User user = userMapper.get(id);
        return user;
    }

    @Override
    public PageList findPage(BaseQuery baseQuery) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Override
    public void update(User user) throws Exception{
        String userName = user.getUserName();
        User queryUser = userMapper.getUserByUserName(userName);
        if (queryUser == null) {
            throw new CRUDException(CRUDException.UPDATE_EXCEPTION, "更新的用户不存在");
        }
        userMapper.update(user);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName){
        User user = userMapper.getUserByUserName(userName);
        return user;
    }

    /**
     * 根据用户名锁定用户
     *
     * @param userName
     */
    @Override
    public void lockUser(String userName) {

    }

    /**
     * 根据用户名解锁用户
     *
     * @param username
     */
    @Override
    public void unlockUser(String username) {

    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public List<User> queryUserByUserName(String userName) {
        return null;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    /**
     * 用户登录
     *
     * @param user
     */
    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        User queryUser = null;
        if (u != null) {
            u.setCredit(u.getCredit()+5);
            u.setLastVisit(new Date());
            userMapper.updateCredit(u);
            queryUser = userMapper.getUserByUserName(user.getUserName());
        }
        return queryUser;
    }
}
