package com.swust.fund.dao;

import com.swust.fund.entity.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    AdminUser findByAdminLoginName(String loginName);
}