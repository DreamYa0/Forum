package com.zbj.forum.service.impl;

import com.zbj.forum.entity.Board;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.mapper.BoardMapper;
import com.zbj.forum.query.BaseQuery;
import com.zbj.forum.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dreamyao on 2017/1/27.
 */
@Service
public class BoardServiceImpl implements IBoardService {

    @Autowired
    private BoardMapper boardMapper;


    /**
     * 创建论坛
     *
     * @param board
     */
    @Override
    public void createBoard(Board board) throws Exception{
        String boardName=board.getBoardName();
        Board queryBoard = this.getBoardMassage(boardName);
        if (queryBoard != null) {
            throw new CRUDException(CRUDException.UPDATE_EXCEPTION, "有相同的论坛板块名存在!");
        }
        boardMapper.createBoard(board);
    }

    /**
     * 根据论坛板块名获取论坛信息
     *
     * @param boardName
     * @return
     */
    @Override
    public Board getBoardMassage(String boardName) throws Exception{
        Board board = boardMapper.getBoardMassage(boardName);
        return board;
    }

    /**
     * 保存
     *
     * @param board
     */
    @Override
    public void save(Board board) {

    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {

    }

    /**
     * 更新
     *
     * @param board
     */
    @Override
    public void update(Board board) {

    }

    /**
     * 根据id来查找
     *
     * @param id
     * @return
     */
    @Override
    public Board get(Integer id) {
        return null;
    }

    /**
     * 得到所有
     *
     * @return
     */
    @Override
    public List<Board> getAll() {
        return null;
    }

    /**
     * 查询统计数
     *
     * @param Query
     */
    @Override
    public Integer getCount(BaseQuery Query) {
        return null;
    }

    /**
     * 高级查询+分页
     *
     * @param Query
     */
    @Override
    public List<Board> findByQuery(BaseQuery Query) {
        return null;
    }
}
