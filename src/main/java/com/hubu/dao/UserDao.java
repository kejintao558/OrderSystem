package com.hubu.dao;

import com.hubu.entity.Page;
import com.hubu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public void add(User user);//增加用户

    public void delete(User user);//删除用户

    public User findById(int id);//根据用户id查


    public void update(User user);//改

    public List<Map<String, String>> getInfo(Page page);
//    //根据用户名查
//    public User checkUsername(String username);

    //根据用户名和用户密码查
    public User checkPassword(User user);

    //查询用户权限
    public String checkAuthority(User user);

    //查询所有
    public List<User> findAll();

    public int total();

    public List<String> getRealname(int depid);//根据岗位id查询用户名字
}
