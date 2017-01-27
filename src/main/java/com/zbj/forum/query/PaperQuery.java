package com.zbj.forum.query;

/**
 * Created by yijun on 2016-7-17.
 */
public class PaperQuery extends BaseQuery {
    private Long id;
    private String start;
    private String end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start + "-01-01";
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end + "-12-31";
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
