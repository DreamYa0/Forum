package com.zbj.forum.mapper;

import com.zbj.forum.entity.Board;
import org.springframework.stereotype.Repository;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Repository
public interface BoardMapper extends BaseMapper<Board> {

    /**
     * 根据论坛版块名获取论坛版块信息
     */
    Board getBoardMassage(String boardName);

    /**
     * 新建论坛
     * @param board
     */
    void createBoard(Board board);
}
