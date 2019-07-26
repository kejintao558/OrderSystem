package com.hubu.controller;


import com.hubu.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("authority")
@Api("权限操作类")
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;


    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有权限",notes = "查询权限")
    public List<String> getRole(){
        return authorityService.getRole();
    }



}
