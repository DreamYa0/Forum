package com.zbj.forum.web.controller;

import com.zbj.forum.entity.Board;
import com.zbj.forum.service.IBoardService;
import com.zbj.forum.utils.CheckDataUtil;
import com.zbj.forum.web.common.CommonResult;
import com.zbj.forum.web.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.zbj.forum.utils.CheckDataUtil.updateBoardCheck;
import static com.zbj.forum.web.common.CommonResult.PARAMETER_ERROR;
import static com.zbj.forum.web.common.CommonResult.STATUS_SUCCESS;

/**
 * Created by dreamyao on 2017/1/27.
 */
@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private IBoardService boardService;

    /**
     * 创建论坛板块
     * @param board
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createBoard",method = RequestMethod.POST)
    public CommonResult createBoard(@RequestBody Board board){
        if (!CheckDataUtil.createBoardCheck(board)) {
            return new CommonResult("参数错误!");
        }
        boardService.createBoard(board);
        return new CommonResult(STATUS_SUCCESS, "论坛板块创建成功!");
    }

    /**
     * 根据论坛板块名称查询论坛信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBoardMessage",method = RequestMethod.POST)
    public Result<Board> getBoardMessage(String boardName){
        if (boardName.equals("") && boardName.isEmpty()) {
            return new Result(PARAMETER_ERROR,"参数错误!");
        }
        Board board = boardService.getBoardMassage(boardName);

        return new Result<>(board);
    }

    /**
     * 论坛信息更新
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> updateBoard(@RequestBody Board board) {
        Result<Boolean> result=null;
        if (!updateBoardCheck(board)) {
            result.setErrorCode(PARAMETER_ERROR);
            result.setErrorMsg("参数错误!");
            return result;
        }
        boardService.update(board);
        result.setData(true);
        return result;
    }
}
