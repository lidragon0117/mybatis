package com.LiLong;

import com.LiLong.dao.impl.AdminDaoImpl;
import com.LiLong.domain.Admin;

import java.util.List;

public class MyAppUtilText {
    public static void main(String[] args) {
        AdminDaoImpl adminDao=new AdminDaoImpl();
        List<Admin> list =adminDao.findAll();
        for (Admin a:
             list) {
            System.out.println(a);
        }
        Admin admin=new Admin();
        admin.setUserName("张三");
        admin.setPassword("123");
        admin.setSex("女");
        admin.setTel("123");
        admin.setName("张三");

        int num=adminDao.insertInfro(admin);
        System.out.println("输出结果："+num);
    }

}
