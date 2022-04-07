package com.LiLong.dao;

import com.LiLong.domain.Admin;

import java.util.List;

//接口操作admin
public interface AdminDao {
    //查询
    public List<Admin> findAll();
    //插入操作，影响插入的行数
    public int insertInfro(Admin admin);

}
