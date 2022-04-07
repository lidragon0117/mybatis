package com.LiLong.dao;

import com.LiLong.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    public List<Admin> selectAll();

    /**
      *简单参数
     */
    public List<Admin> selectById(int adminId);

    /**
     * 多个参数
     */
    public List<Admin> selectByMoreNum(@Param("myname") String name);
     public int count();
    /**
     * 使用like进行模糊查询
     */
    public List<Admin>  likeselect(String userName);
    public List<Admin>  likeselectTwo(String userName);
    /**
     * 测试if标签
     *
     */
    public List<Admin> ifselect(String userName) ;
    public List<Admin> whereselect(String userName);
    /**
     * 测试动态Sql代码块
     */
    public List<Admin> selectBydongtaiSql();
    /**
     * 测试pageHelper
     */
    public List<Admin> selectByHelper();


}
