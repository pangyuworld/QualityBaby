package com.swust.fund.common;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: PageHandler
 * @Package com.swust.fund.common
 * @description: 分页生成
 * @date 2019/5/5 15:13
 */
public abstract class PageHandler<E> {
    private int pageNum;
    private int pageSize;
    public abstract List<E> getLists();
    public abstract Integer getCount();

    public PageHandler(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;

    }

    public int getPageNum() {
        return pageNum;
    }

    public PageHandler<E> setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageHandler<E> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
