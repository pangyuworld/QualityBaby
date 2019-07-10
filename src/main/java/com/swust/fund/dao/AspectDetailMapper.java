package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.AspectDetail;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AspectDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(AspectDetail record);

    int insertSelective(AspectDetail record);

    AspectDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(AspectDetail record);

    int updateByPrimaryKey(AspectDetail record);

    List<AspectDetail> selectAllAspectDetail(@Param("showAll") Boolean showAll);

    List<AspectDetail> selectAllAspectDetailByAspect(@Param("aspectId") Integer aspectId, @Param("showAll") Boolean showAll);
}