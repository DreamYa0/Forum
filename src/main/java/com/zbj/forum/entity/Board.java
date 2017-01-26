package com.zbj.forum.entity;

import java.io.Serializable;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class Board implements Serializable{
    private static final long serialVersionUID = -4309350821355770567L;
    /**
     * 论坛版块ID
     */
    private Integer id;

    /**
     * 论坛版块名
     */
    private String boardName;

    /**
     * 论坛版块描述
     */
    private String boardDesc;

    /**
     * 帖子数目
     */
    private Integer topicNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc;
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }
}
