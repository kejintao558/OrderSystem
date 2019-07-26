package com.hubu.service;

import com.hubu.entity.Page;
import com.hubu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();//查询所有用户
    void add(User user);//添加用户
    void update(User user);//更改用户信息
    void delete(User user);//根据用户id删除用户
    User get(int id);//根据用户id查询用户
    User getUser(User user);//根据用户名和密码查询用户
    List<Map<String,String>> getInfo(Page page);
    int total();
    public List<String> getRealname(int depid);//根据岗位id查询用户名字

//    //检验用户登录
//    boolean checkLogin(User user);
//    boolean checkPassword(User user);
    //查询用户权限
    String checkAuthority(User user);
}
