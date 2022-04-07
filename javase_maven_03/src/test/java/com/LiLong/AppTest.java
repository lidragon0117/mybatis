package com.LiLong;

import static org.junit.Assert.assertTrue;

import com.LiLong.dao.AdminDao;
import com.LiLong.domain.Admin;
import com.LiLong.utils.mybatistools;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.ClientInfoStatus;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 测试的单个参数
     */
    @Test
    public void selectById() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<Admin> list = adminDao.selectById(4);
        for (Admin a : list
        ) {
            System.out.println(a.getName());
        }
    }

    /**
     * 测试多个参数
     */
    @Test
    public void selectByMoreNum() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);

        List<Admin> list = adminDao.selectByMoreNum("李四");
        for (Admin a : list
        ) {
            System.out.println(a);
        }

    }

    /**
     * 测试定义别名（1）
     * 返回一行一列
     */
    @Test
    public void selectCount() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao admin = sqlSession.getMapper(AdminDao.class);
        int num = admin.count();
        System.out.println("数量为：" + num);
    }

    /**
     * 模糊查询
     */
    @Test
    public void likeSelect() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        String userName = "李%";
        List<Admin> admins = adminDao.likeselect(userName);
        for (Admin a : admins
        ) {
            System.out.println(a);
        }
    }

    /**
     * 第二种测试方法
     */
    @Test
    public void likeselectTwo() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        String userName = "李";
        List<Admin> admins = adminDao.likeselectTwo(userName);
        for (Admin a : admins
        ) {
            System.out.println(a);
        }
    }

    /**
     * 测试if标签
     */
    @Test
    public void ifselect() {
        SqlSession sqlSession = mybatistools.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        String userName = "李四";
        List<Admin> admins = adminDao.ifselect(userName);
        for (Admin a : admins
        ) {
            System.out.println(a);
        }

    }
    /**
     * where的测试
     */
    @Test
    public void whereselectText(){
        SqlSession session=mybatistools.getSqlSession();
        AdminDao adminDao1=session.getMapper(AdminDao.class);
        String userNames="李四";
        List<Admin> adminList=adminDao1.whereselect(userNames);

        for (Admin a:adminList
             ) {
            System.out.println(a);
        }
    }
    /**
     * 测试动态sql代码块
     */
    @Test
    public void selectBydongtaiSql(){
        SqlSession session=mybatistools.getSqlSession();
        AdminDao adminDao=session.getMapper(AdminDao.class);
        List<Admin> list=adminDao.selectBydongtaiSql();
        for (Admin a:list
             ) {
            System.out.println(a);
        }
    }
    /**
     * 测试pageHelper
     */
    @Test
    public void selectByHelper(){
        SqlSession session=mybatistools.getSqlSession();
        AdminDao adminDao=session.getMapper(AdminDao.class);
        PageHelper.startPage(1,2);
        List<Admin> list=adminDao.selectByHelper();
        for (Admin a:list
             ) {
            System.out.println(a);
        }

    }
}
