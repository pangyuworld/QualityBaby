package com.swust.fund.dao;

import com.swust.fund.entity.AspectDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AspectDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(AspectDetail record);

    int insertSelective(AspectDetail record);

    AspectDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(AspectDetail record);

    int updateByPrimaryKey(AspectDetail record);

    List<AspectDetail> selectAllAspectDetail(@Param("showAll") Boolean showAll);

    List<AspectDetail> selectAllAspectDetailByAspect(@Param("aspectId") Integer aspectId, @Param("showAll") Boolean showAll);

    int insertScore(@Param("userId") int userId, @Param("scoreMap") Map<Integer, Integer> scoreMap);

    List<Map> selectDetailScoreByUser(@Param("userId") Integer userId, @Param("aspectId") Integer aspectId);
}