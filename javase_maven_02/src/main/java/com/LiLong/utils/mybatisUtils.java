package com.LiLong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisUtils {
    private static  InputStream in =null ;
     private static SqlSessionFactory factory=null;
    static {
        String congif="mybatis.xml";
        try {
           in= Resources.getResourceAsStream(congif);
            //创建SqlSessionFactoy对象
             factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
