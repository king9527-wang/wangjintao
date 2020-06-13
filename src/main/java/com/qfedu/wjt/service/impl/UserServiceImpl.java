package com.qfedu.wjt.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.wjt.dao.UserDao;
import com.qfedu.wjt.pojo.Info;
import com.qfedu.wjt.pojo.User;
import com.qfedu.wjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String userName, String password) {
        User user = userDao.findByName(userName);
        if (user == null) {
            throw new RuntimeException("账户错误");
        }
        if (!user.getPassWord().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public List<Info> findAll(String searchInfo) {
        return userDao.findAll(searchInfo);
    }

    @Override
    public Map<String, Object> findByPage(Integer page, Integer limit,String searchInfo) {
        PageHelper.startPage(page,limit);
        List<Info> list = userDao.findAll(searchInfo);
        long total = ((Page) list).getTotal();
        int pages = ((Page) list).getPages();

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);
        for (Info info : list) {
            System.out.println("impl:"+info);
        }
        return map;

    }

    @Override
    public Info findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int deleteInfo(Integer id) {
        return userDao.deleteInfo(id);
    }

    @Override
    public void addInfo(Info info) {
        userDao.addInfo(info);
    }

    @Override
    public int updateInfo(Info info) {
        System.out.println("更新数据:"+info);
        return userDao.updateInfo(info);
    }

    @Override
    public int addRegisterInfo(User user) {
        return userDao.addRegisterInfo(user);
    }

    @Override
    public int updatePassword(User user) {
        return userDao.updatePassword(user);
    }

    @Override
    public User selectByName(String userName) {
        return userDao.findByUser(userName);
    }
}
