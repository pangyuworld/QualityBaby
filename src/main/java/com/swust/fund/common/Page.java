package com.swust.fund.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Page
 * @Package com.swust.fund.common
 * @description: 分页查询结果集
 * @date 2019/5/5 15:06
 */
@ApiModel("统一分页返回样式")
public class Page<E> {
    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private Integer pageNum;
    /**
     * 页大小
     */
    @ApiModelProperty("页大小")
    private Integer pageSize;
    /**
     * 总条数
     */
    @ApiModelProperty("总条数")
    private Integer total;
    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private Integer totalPage;
    /**
     * 是否还有下一页
     */
    @ApiModelProperty("是否还有下一页")
    private Boolean count;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private List data;

    /**
     * @param data     已分页数据
     * @param total    数据总数
     * @param pageNum  页码
     * @param pageSize 大小
     * @return
     * @author pang
     * @date 2019/5/11
     */
    public Page(List data, int total, int pageNum, int pageSize) {
        // TODO 赋值数据
        // data = handler.getLists();
        this.data = data;
        // TODO 获得总数
        // total = handler.getCount();
        this.total = total;
        // TODO 获得页码
        // this.pageNum = handler.getPageNum();
        this.pageNum = pageNum;
        // TODO 获得页大小
        // this.pageSize = handler.getPageSize();
        this.pageSize = pageSize;
        // TODO 获得总页数
        try {
            totalPage = total / pageSize;
            // TODO 如果不能整除，还需要再加一页
            if (total % pageSize > 0) {
                totalPage++;
            }
        } catch (NullPointerException e) {
            // TODO 除数为0的操作
            e.printStackTrace();
            totalPage = 0;
        }
        // TODO 判断是否还有下一页
        count = pageNum < totalPage;
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
