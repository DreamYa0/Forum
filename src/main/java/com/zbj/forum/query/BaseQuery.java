package com.zbj.forum.query;

/**
 * Created by DreamYao on 2017/1/24.
 */
public abstract class BaseQuery {

    //一页多少条
    private Integer pageSize = 10;
    //当前页
    private Integer currentPage = 1;

    private Integer beginIndex;

    /**
     * @return 起始条数
     */
    public Integer getBeginIndex() {
        return (currentPage - 1) * pageSize;
    }

    public void setBeginIndex(Integer beginIndex) {
        this.beginIndex = beginIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }
}
