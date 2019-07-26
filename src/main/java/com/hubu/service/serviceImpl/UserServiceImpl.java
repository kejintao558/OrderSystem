package com.hubu.service.serviceImpl;

import com.hubu.dao.UserDao;
import com.hubu.entity.Page;
import com.hubu.entity.User;
import com.hubu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao UserDao;


    @Override
    public List<User> findAll() {
        return UserDao.findAll();
    }

    //添加用户
    @Override
    public void add(User user) {
        UserDao.add(user);

    }

    //更改用户信息
    @Override
    public void update(User user) {
        UserDao.update(user);
    }

    //删除用户
    @Override
    public void delete(User user) {
        UserDao.delete(user);
    }

    //根据用户id查询用户
    @Override
    public User get(int id) {
        return UserDao.findById(id);
    }

    //根据用户名和用户密码查询用户
    @Override
    public User getUser(User user) {
        return UserDao.checkPassword(user);
    }

//    //验证用户名
//    @Override
//    public boolean checkLogin(User user) {
//        String username = user.getUsername();
//        if( UserDao.checkUsername(username)!= null ){
//            return true;
//        }
//        else
//            return false;
//    }

//    //验证用户密码
//    @Override
//    public boolean checkPassword(User user) {
//        if( UserDao.checkPassword(user)!= null ){
//            return true;
//        }
//        else
//            return false;
//    }

    //查询用户权限
    @Override
    public String checkAuthority(User user) {
        return UserDao.checkAuthority(user);
    }

    //查询用户具体信息，结果集
    @Override
    public List<Map<String,String>> getInfo(Page page) {
        return UserDao.getInfo(page);
    }

    @Override
    public int total() {
        return UserDao.total();
    }

    @Override
    public List<String> getRealname(int depid) {
        return UserDao.getRealname(depid);
    }
}
