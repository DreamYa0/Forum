package com.zbj.forum.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class Topic implements Serializable {
    /**
     * 帖子ID
     */
    private Integer id;

    /**
     * 所属论坛
     */
    private Integer boardId;

    /**
     * 帖子标题
     */
    private String topicTitle;

    /**
     * 发表用户
     */
    private Integer userId;

    /**
     * 发表时间
     */
    private Date createTime;

    /**
     * 最后回复时间
     */
    private Date lostPost;

    /**
     * 浏览数
     */
    private Integer topicViews;

    /**
     *
     */
    private Integer topicReplies;

    /**
     * 0:不是精华话题 1：是精华话题
     */
    private int digest;

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

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLostPost() {
        return lostPost;
    }

    public void setLostPost(Date lostPost) {
        this.lostPost = lostPost;
    }

    public Integer getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(Integer topicViews) {
        this.topicViews = topicViews;
    }

    public Integer getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(Integer topicReplies) {
        this.topicReplies = topicReplies;
    }

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }
}
