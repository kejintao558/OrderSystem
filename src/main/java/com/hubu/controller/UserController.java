package com.hubu.controller;

import com.hubu.entity.Page;
import com.hubu.entity.User;
import com.hubu.service.DepartmentService;
import com.hubu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("test")
@Api(tags = "用户接口信息")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @RequestMapping("/test1")
    public String test(){
        return "test";
    }

    @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value= "根据用户id查询用户",notes = "查询用户")
    public User getUser(User user){
        user.setId(user.getId());
        user = userService.get(user.getId());
        return user;
    }

    @RequestMapping(value = "/userInfo",method=RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="根据用户名和用户密码查询用户",notes = "查询用户")
    public User findUser(@RequestParam("username") String urm,@RequestParam("password") String psd){
        User user= new User();
        user.setUsername(urm);
        user.setPassword(psd);
        user = userService.getUser(user);
        return user;
    }

    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="添加用户",notes = "添加用户")
    public void add(@RequestBody User user){
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRealname(user.getRealname());
        user.setRoleid(user.getRoleid());
        user.setDepid(user.getDepid());
        userService.add(user);
    }


    @RequestMapping(value="/updateUser",method=RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="更改用户信息",notes="更改用户信息")
    public void updateUser(@RequestBody User user){
        user.setId(user.getId());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setRealname(user.getRealname());
        user.setRoleid(user.getRoleid());
        user.setDepid(user.getDepid());
        userService.update(user);

    }

    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value="根据用户id删除用户",notes = "删除用户")
    public void deleteUser(int id){
        User user = new User();
        user.setId(id);
        userService.delete(user);
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询用户具体信息",notes = "查询用户具体信息")
    public List<Map<String,String>> getUser(@RequestParam("pagenumber")int pagenum){
        Page page = new Page();
        page.setStart((pagenum-1)*page.getCount());
        int total = userService.total();
        page.caculateLast(total);
        System.out.println(page);
        List<Map<String,String >> lm= userService.getInfo(page);
        return lm;
    }


}

