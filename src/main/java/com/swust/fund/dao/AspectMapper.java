package com.swust.fund.dao;

import com.swust.fund.entity.Aspect;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AspectMapper {
    int deleteByPrimaryKey(Integer aspectId);

    int insert(Aspect record);

    int insertSelective(Aspect record);

    Aspect selectByPrimaryKey(Integer aspectId);

    int updateByPrimaryKeySelective(Aspect record);

    int updateByPrimaryKey(Aspect record);

    List<Aspect> selectAllAspect(@Param("showAll") Boolean showAll);

    List<Map> selectScoreByUser(@Param("userId") Integer userId);

    List<Integer> selectAllAspectId();

    List<Integer> selectAllUserAspectSort(@Param("aspectId") Integer aspectId);

    int deleteAspectSort();

    int updateAspectSort(List<Map<String,Integer>> sortMapList);

    List<Map> selectAspectSortByUser(@Param("userId") Integer userId);
}