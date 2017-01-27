package com.zbj.forum.query;

import java.io.Serializable;

/**
 * 分页信息记录实体
 * 类名称：QueryPageBean 类描述:
 */
public class QueryPageModel implements Serializable {
    /**
     * @apiDefine QueryPageModel QueryPageModel
     * @apiParam (QueryPageModel) {Integer} startIndex
     * @apiParam (QueryPageModel) {Integer} pageSize
     * @apiParam (QueryPageModel) {Integer} orderByClause
     * @apiParam (QueryPageModel) {Integer} pageNo
     */
    private static final long serialVersionUID = 3987115680525820105L;

    public static final int PAGE_NO = 1;

    public static final int PAGE_SIZE = 20;

    private Integer startIndex = 0;

    private Integer pageSize = 10;

    private String orderByClause;

    private Integer pageNo;

    public QueryPageModel() {

    }

    /**
     * 只做排序，不分页
     *
     * @param orderByClause
     */
    public QueryPageModel(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public QueryPageModel(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 1) {
            pageNo = PAGE_NO;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = PAGE_SIZE;
        }
        this.pageNo = pageNo;
        this.startIndex = (this.pageNo - 1) * pageSize;
        this.pageSize = pageSize;
    }

    public QueryPageModel(Integer pageNo, Integer pageSize, String orderBy) {
        if (pageNo == null || pageNo < 1) {
            pageNo = PAGE_NO;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = PAGE_SIZE;
        }
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.orderByClause = orderBy;
        startIndex = (this.pageNo - 1) * pageSize;
    }

    private void setStartIndex(Integer startIndex) {
        if (startIndex == null || startIndex < 0) {
            startIndex = PAGE_NO;
        }
        this.startIndex = startIndex;
    }

    public Integer getStartIndex() {
        if (pageNo != null && pageSize != null) {
            startIndex = (this.pageNo - 1) * pageSize;
        }
        return startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            pageSize = PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    private void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = PAGE_NO;
        }
        this.pageNo = pageNo;
    }
}

