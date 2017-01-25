package com.zbj.forum.mapper;

import com.zbj.forum.entity.Board;
import org.springframework.stereotype.Repository;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Repository
public interface BoardMapper extends BaseMapper<Board> {

    /**
     * 根据论坛版块ID获取论坛版块信息
     */
    Board getBoardMassage(Integer id);
}
