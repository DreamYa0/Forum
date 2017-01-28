package com.zbj.forum.service.impl;

import com.zbj.forum.entity.User;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.exception.ExceptionCode;
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
    public void delete(Integer id) {
        User user = this.get(id);
        if (user != null) {
            userMapper.delete(id);
        }
        throw new CRUDException(ExceptionCode.HAVE_NOT_DATA, "删除的用户不存在");

    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param id t_user表主键Id
     * @return
     */
    @Override
    public User get(Integer id) throws NullPointerException {
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
     * 更新用户信息(包括密码修好、用户锁定、用户解锁)
     *
     * @param user
     */
    @Override
    public void update(User user) {
        String userName = user.getUserName();
        User queryUser = userMapper.getUserByUserName(userName);
        if (queryUser == null) {
            throw new CRUDException(ExceptionCode.HAVE_NOT_DATA, "更新的用户不存在");
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
    public User getUserByUserName(String userName) {
        User user = userMapper.getUserByUserName(userName);
        if (user == null) {
            throw new CRUDException(ExceptionCode.HAVE_NOT_DATA,"用户名不存在");
        }
        return user;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        if (userList != null || userList.size() > 0) {
            return userList;
        } else {
            throw new CRUDException(ExceptionCode.HAVE_NOT_DATA, "数据库中没有用户!");
        }
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
            /*没登录一次增加5点积分*/
            u.setCredit(u.getCredit() + 5);
            /*更新访问时间*/
            u.setLastVisit(new Date());
            userMapper.updateCredit(u);
            queryUser = userMapper.getUserByUserName(user.getUserName());
        }
        return queryUser;
    }
}
