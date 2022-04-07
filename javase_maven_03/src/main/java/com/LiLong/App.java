package com.LiLong;

import com.LiLong.dao.AdminDao;
import com.LiLong.domain.Admin;
import com.LiLong.utils.mybatistools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        SqlSession sqlSession= mybatistools.getSqlSession();
        //动态代理
        AdminDao adminDao=sqlSession.getMapper(AdminDao.class);
        List<Admin> st =adminDao.selectAll();
        for (Admin a:st
             ) {
            System.out.println("这是："+a);
        }

    }
}
