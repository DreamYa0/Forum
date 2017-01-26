package com.zbj.forum.service;

import com.zbj.forum.query.BaseQuery;
import com.zbj.forum.query.PageList;

import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
public interface IBaseService<T> {

    // 保存信息
    void save(T t);

    // 编辑信息
    void update(T t) throws Exception;

    // 删除
    void delete(Integer id) throws Exception;

    // 查询
    T get(Integer id) throws NullPointerException;

    // 高级查询+分页
    PageList findPage(BaseQuery baseQuery);

    //查询所有
    List<T> getAll();
}
