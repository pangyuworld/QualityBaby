package com.swust.fund.dao;

import com.github.pagehelper.Page;
import com.swust.fund.entity.AdminLoginLog;

public interface AdminLoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminLoginLog record);

    int insertSelective(AdminLoginLog record);

    AdminLoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminLoginLog record);

    int updateByPrimaryKey(AdminLoginLog record);

    Page<AdminLoginLog> selectAllLog();
}