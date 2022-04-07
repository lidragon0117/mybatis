package com.LiLong;

import com.LiLong.domain.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取数据
        //1.定义mybatis主配置的文件
        String conigf="mybatis.xml";
        //2.读取这个文件
        InputStream in= Resources.getResourceAsStream(conigf);
        //创建sqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //获取SQLSession对象，从SqlSessionFactory中获取SQLSession
        SqlSession sqlSession=factory.openSession();
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
