package com.zbj.forum.entity;

import java.io.Serializable;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class BoardManager implements Serializable {

    private Integer boardId;
    private Integer userId;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
