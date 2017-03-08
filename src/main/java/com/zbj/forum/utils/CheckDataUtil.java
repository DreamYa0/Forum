package com.zbj.forum.utils;

import com.zbj.forum.entity.Board;
import com.zbj.forum.entity.User;

/**
 * Created by DreamYao on 2017/1/26.
 */
public class CheckDataUtil {

    // 用户更新参数检查
    public static Boolean updateUserCheck(User user) {
        String userName = user.getUserName();
        Integer userType = user.getUserType();
        Integer locked = user.getLocked();
        Integer credit = user.getCredit();
        if (user == null || userName == null || userName.equals("") ||
                userType == null || locked == null || credit != null) {
            return false;
        } else if (userType != 2 || userType != 1 || locked != 0 || locked != 1 ||
                credit < 0) {
            return false;
        } else {
            return true;
        }
    }

    // 论坛创建参数检查
    public static Boolean createBoardCheck(Board board) {
        String boardName = board.getBoardName();
        String boardDesc = board.getBoardDesc();
        if (board == null && boardName.equals("") && boardName == null
                && boardName.isEmpty() && boardDesc.equals("")
                && boardDesc.isEmpty() && boardDesc == null) {
            return false;
        }
        return true;
    }

    // 论坛更新参数检查
    public static Boolean updateBoardCheck(Board board) {
        String boardName = board.getBoardName();
        String boardDesc = board.getBoardDesc();
        Integer id = board.getId();
        if (board == null && (boardName.equals("") && boardName == null
                && boardName.isEmpty()) || (boardDesc.equals("")
                && boardDesc.isEmpty() && boardDesc == null)
                && id == null && id > 0) {
            return false;
        }
        return true;
    }
}
