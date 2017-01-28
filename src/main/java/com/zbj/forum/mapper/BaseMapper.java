package com.zbj.forum.mapper;

import com.zbj.forum.query.BaseQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
@Repository
public interface BaseMapper<T> {
    /**
     * 保存
     *
     * @param
     */
    void save(T t);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新
     *
     * @param
     */
    void update(T t);

    /**
     * 根据id来查找
     *
     * @param id
     * @return
     */
    T get(Integer id);

    /**
     * 得到所有
     *
     * @return
     */
    List<T> getAll();

    /**
     * 查询统计数
     */
    Integer getCount(BaseQuery Query);

    /**
     * 高级查询+分页
     */
    List<T> findByQuery(BaseQuery Query);
}
