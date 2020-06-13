package com.qfedu.wjt.dao;

import com.qfedu.wjt.pojo.Info;
import com.qfedu.wjt.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public User findByName(String userName);
    public List<Info> findAll(@Param("searchInfo") String searchInfo);
    public Info findById(Integer id);
    public int deleteInfo(Integer id);
    public void addInfo(Info info);
    public int updateInfo(Info info);
    public int addRegisterInfo(User user);
    public int updatePassword(User user);
    public User findByUser(String userName);
}
