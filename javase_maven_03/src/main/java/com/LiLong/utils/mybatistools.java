package com.LiLong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatistools {
   private static SqlSessionFactory factory=null;
    private static InputStream in =null;
    static{
        String config="mybatis.xml";
        try {
            in= Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
       if(factory!=null){
           sqlSession= factory.openSession();
       }
       return sqlSession;
    }
}
