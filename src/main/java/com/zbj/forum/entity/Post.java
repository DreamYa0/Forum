package com.zbj.forum.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class Post implements Serializable {

    /**
     * 帖子ID
     */
    private Integer id;

    /**
     * 论坛ID
     */
    private Integer boardId;

    /**
     * 话题ID
     */
    private Integer topicId;

    /**
     * 发表者ID
     */
    private Integer userId;

    /**
     * 帖子类型：1主帖子 2：回复帖子
     */
    private Integer postType;

    /**
     * 帖子标题
     */
    private String postTitle;

    /**
     * 帖子内容
     */
    private String postText;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
