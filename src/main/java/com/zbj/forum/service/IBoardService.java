package com.zbj.forum.service;

import com.zbj.forum.entity.Board;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.mapper.BaseMapper;

/**
 * Created by dreamyao on 2017/1/27.
 */
public interface IBoardService {

    /**
     * 创建论坛板块
     * @param board
     */
    void createBoard(Board board);

    /**
     * 根据论坛板块名获取论坛信息
     * @param boardName
     * @return
     */
    Board getBoardMassage(String boardName);

    /**
     * 根据论坛板块ID获取论坛信息
     *
     * @param id
     * @return
     */
    Board getMessageById(Integer id) throws CRUDException;

    /**
     * 更新
     * @param board
     */
    void update(Board board);
}
