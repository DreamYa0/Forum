package com.zbj.forum.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DreamYao on 2017/1/24.
 */
public class PageList {

    //想得到的页数,俗称当前页,
    private Integer currentPage;
    //总数据
    private Integer totalCount;
    //一页显示多少条
    private Integer pageSize;
    //最后一页
    private Integer lastPage;
    //new 一个data来装满足条件的数据
    private List data = new ArrayList();

    public PageList() {
    }


    public PageList(Integer pageSize, Integer currentPage) {
        this.pageSize=pageSize;
        this.currentPage=currentPage;
    }


    public PageList(Integer pageSize, Integer currentPage, Integer totalCount, List data) {
        this.pageSize=pageSize;
        this.currentPage=currentPage;
        this.totalCount = totalCount;
        this.lastPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.data = data;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", lastPage=" + lastPage +
                ", data=" + data +
                '}';
    }
}
