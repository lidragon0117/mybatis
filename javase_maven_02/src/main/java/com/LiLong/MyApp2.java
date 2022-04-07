package com.LiLong;

import com.LiLong.domain.Admin;
import com.LiLong.utils.mybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        //获取SQLSession对象，从SqlSessionFactory中获取SQLSession
        SqlSession sqlSession= mybatisUtils.getSqlSession();
        //指定重要执行语句，sql映射文件中的nameSpace+“.”+标签的id
        String sqlI="com.LiLong.dao.AdminDao"+"."+"findall";
        //执行sql语句
        List<Admin> adminList =sqlSession.selectList(sqlI);
        //输出
        for (Admin a:adminList
             ) {
            System.out.println(a);
        }
        sqlSession.close();
    }
}
