package com.zbj.forum.utils;

import com.zbj.forum.entity.Board;
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
        } else if (userType != null) {
            if (userType == 2 || userType == 1) {
                return true;
            } else {
                return false;
            }
        } else if (locked != null) {
            if (locked == 0 || locked == 1) {
                return true;
            } else {
                return false;
            }
        } else if (credit != null) {
            if (credit >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static Boolean createBoardCheck(Board board) {
        String boardName=board.getBoardName();
        String boardDesc=board.getBoardDesc();
        if (board == null && boardName.equals("") && boardName == null
                && boardName.isEmpty() && boardDesc.equals("")
                && boardDesc.isEmpty() && boardDesc == null) {
            return false;
        }
        return true;
    }
}
