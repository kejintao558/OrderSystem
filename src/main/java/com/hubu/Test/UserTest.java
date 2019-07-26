package com.hubu.Test;

import com.hubu.dao.UserDao;
import com.hubu.entity.User;
import com.hubu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class UserTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void findAll()
    {

        List<User> user = userService.findAll();
        System.out.println(user);


//       User user = userDao.findById(3);
//       System.out.println("test" + user);

//        User user = new User();
//        user.setUsername("123");
//        user.setPassword("123");
//        user = userDao.checkPassword(user);
//        System.out.println(user.getRoleid());
//        System.out.println(userService.checkAuthority(user));




    }
}
