package com.example.student_command.entity;

import java.util.List;

/**
 * @author xiaobao
 */
public class Pager<T> {
    /**
     * 返回的记录集合
     */
    private List<T> rows;
    /**
     * 总记录条数
     */
    private long total;

    public Pager() {
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
