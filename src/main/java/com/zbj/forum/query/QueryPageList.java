package com.zbj.forum.query;

import java.io.Serializable;
import java.util.List;

/**
 * 分页处理对象
 * Created by dreamyao on 2017/1/27.
 */
public class QueryPageList<T> implements Serializable {

    /**
     * @apiDefine QueryPageList QueryPageList
     * @apiParam (QueryPageList) {resultList} resultList 存放结果集
     * @apiParam (QueryPageList) {pageBean} pageBean 分页信息
     */
    private static final long serialVersionUID = 1L;

    /**
     * 存放结果集
     */
    private List<T> resultList;

    /**
     * 分页信息
     */
    private QueryPageBean pageBean;

    public QueryPageList(QueryPageBean pageBean) {
        this.pageBean = pageBean;
    }

    /**
     * 带参构造方法
     *
     * @param resultList 结果集
     * @param pageBean   分页信息
     */
    public QueryPageList(List<T> resultList, QueryPageBean pageBean) {
        this.resultList = resultList;
        this.pageBean = pageBean;
    }

    public QueryPageList(List<T> resultList, QueryPageModel pager, long totalCount) {
        this.resultList = resultList;
        QueryPageBean p = new QueryPageBean(totalCount, pager);
        this.pageBean = p;
    }

    public QueryPageList() {
    }

    /**
     * 得到结果集中的元素
     *
     * @param index 下标
     */
    public T get(int index) {
        return resultList.get(index);
    }

    /**
     * 判断结果集是否为空
     */
    public boolean isEmpty() {
        if (this.resultList == null || this.resultList.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 获取存储的结果集
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * 设置存放的结果集
     *
     * @return 2014年3月21日 下午4:31:38
     * @author FengJianBo
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    /**
     * 获取分页信息
     */
    public QueryPageBean getPageBean() {
        return pageBean;
    }

    /**
     * 设置分页信息
     */
    public void setPageBean(QueryPageBean pageBean) {
        this.pageBean = pageBean;
    }

}

