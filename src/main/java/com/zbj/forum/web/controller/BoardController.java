package com.zbj.forum.web.controller;

import com.zbj.forum.entity.Board;
import com.zbj.forum.exception.CRUDException;
import com.zbj.forum.exception.ExceptionCode;
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
        try {
            boardService.createBoard(board);
        } catch (CRUDException e) {
            e.printStackTrace();
            return new CommonResult("有相同的论坛板块名存在");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult("系统服务异常");
        }
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
        Board board;
        try {
            board = boardService.getBoardMassage(boardName);
            if (board == null) {
                return new Result(ExceptionCode.HAVE_NOT_DATA,"论坛板块信息不存在!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(ExceptionCode.SYSTEM_ERROR,"系统服务异常!");
        }
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
            return new Result(PARAMETER_ERROR,"参数错误!");
        }
        try {
            boardService.update(board);
        } catch (CRUDException e) {
            e.printStackTrace();
            return new Result(ExceptionCode.HAVE_NOT_DATA,"论坛板块ID不存在，更新失败!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(ExceptionCode.SYSTEM_ERROR,"系统服务异常!");
        }
        result.setData(true);
        return result;
    }
}
