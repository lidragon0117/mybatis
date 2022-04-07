package com.LiLong.dao.impl;

import com.LiLong.dao.AdminDao;
import com.LiLong.domain.Admin;
import com.LiLong.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public List<Admin> findAll() {
        SqlSession sqlSession= mybatisUtils.getSqlSession();
        String sqlId="com.LiLong.dao.AdminDao"+"."+"findall";
        List<Admin> admin = sqlSession.selectList(sqlId);
        sqlSession.close();
        return admin;
    }

    @Override
    public int insertInfro(Admin admin) {
        SqlSession sqlSession=mybatisUtils.getSqlSession();
        String sqlId="com.LiLong.dao.AdminDao"+"."+"insertInfro";
         int num=sqlSession.insert(sqlId,admin);
         //手动提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return num;
    }
}
