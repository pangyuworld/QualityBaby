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
public interface PageHandler<E> {
    List<E> getLists();
    Integer getCount();
}
