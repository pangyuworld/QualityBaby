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

    /**
     * 页码
     */
    private int pageNum;
    /**
     * 页大小
     */
    private int pageSize;

    /***
     * 获得数据的方法
     * @author pang
     * @date 19-5-7 上午10:48
     * @parm []
     * @return java.util.List<E>
     */
    public abstract List<E> getLists();

    /***
     * 获得总数的方法
     * @author pang
     * @date 19-5-7 上午10:48
     * @parm []
     * @return java.lang.Integer
     */
    public abstract Integer getCount();

    /***
     * 构造
     * @author pang
     * @date 19-5-7 上午10:49
     * @parm [pageNum, pageSize]
     * @return
     */
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
