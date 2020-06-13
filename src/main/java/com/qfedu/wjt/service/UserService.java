package com.qfedu.wjt.service;

import com.qfedu.wjt.pojo.Info;
import com.qfedu.wjt.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User login(String userName, String password);
    public List<Info> findAll(String searchInfo);
    public Map<String,Object> findByPage(Integer page, Integer limit, String searchInfo);
    public Info findById(Integer id);
    public int deleteInfo(Integer id);
    public void addInfo(Info info);
    public int updateInfo(Info info);
    public int addRegisterInfo(User user);
    public int updatePassword(User user);
    public User selectByName(String userName);
}
