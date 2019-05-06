package com.swust.fund.common;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Page
 * @Package com.swust.fund.common
 * @description: 分页查询结果集
 * @date 2019/5/5 15:06
 */
public class Page<E> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private Integer totalPage;
    private Boolean count;
    private List data;

    public Page(PageHandler handler) {
        data = handler.getLists();
        total = handler.getCount();
        try {
            totalPage = total / pageSize;
        }catch (NullPointerException e){
            // 除数为0的操作
            totalPage = 0;
        }
        this.pageNum = handler.getPageNum();
        this.pageSize = handler.getPageSize();
        count = pageNum<=totalPage;
    }

    public List<E> getList() {
        return data;
    }

    public Page<E> setList(List<E> list) {
        this.data = list;
        return this;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Page<E> setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Page<E> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public Page<E> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Page<E> setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Boolean getCount() {
        return count;
    }

    public Page<E> setCount(Boolean count) {
        this.count = count;
        return this;
    }
}
