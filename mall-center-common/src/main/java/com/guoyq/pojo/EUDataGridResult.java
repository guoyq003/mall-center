package com.guoyq.pojo;

import java.util.List;

public class EUDataGridResult {
    private Integer count;
    private List<?> rows;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
