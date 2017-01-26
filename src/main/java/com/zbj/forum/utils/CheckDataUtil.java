package com.zbj.forum.utils;

import com.zbj.forum.entity.User;

/**
 * Created by DreamYao on 2017/1/26.
 */
public class CheckDataUtil {

    public static Boolean updateUserCheck(User user) {
        String userName = user.getUserName();
        Integer userType = user.getUserType();
        Integer locked = user.getLocked();
        Integer credit = user.getCredit();
        if (user == null || userName == null || userName.equals("")) {
            return false;
        } else if (userType == 2 || userType == 1) {
            return true;
        } else if (locked == 0 || locked == 1) {
            return true;
        } else if (credit >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
