package com.hubu.controller;

import com.hubu.entity.Department;
import com.hubu.entity.Page;
import com.hubu.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dep")
@Api("岗位操作类")
public class DepartmentController {

    @Autowired()
    DepartmentService departmentService;

    @RequestMapping(value="/addDep",method =RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加岗位",notes = "添加岗位")
    public void addDep(@RequestBody Department dep){
        dep.setDepartment(dep.getDepartment());
        departmentService.add(dep);
    }

    @RequestMapping(value = "deleteDep",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "根据岗位id删除岗位",notes = "删除岗位")
    public void deleteDep(int id){
        departmentService.delete(id);
    }

    @RequestMapping(value = "findDep",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据岗位id查询岗位",notes = "查询岗位")
    public Department findDep(@RequestParam("id")int id){
        Department dep = new Department();
        dep.setId(id);
        dep = departmentService.find(dep.getId());
        return dep;
    }

    @RequestMapping(value = "updateDep",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation(value = "更改岗位",notes = "更改岗位")
    public void updateDep(@RequestBody Department dep,@RequestParam String depName){
        int id= departmentService.getId(depName);
        dep.setId(id);
        dep.setDepartment(dep.getDepartment());
        departmentService.update(dep);
    }

    @RequestMapping(value = "getDep",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有岗位",notes = "查询岗位")
    public List<Map> getDep(){
        List<Department> ls = new ArrayList();
        List<Map> lm =new  ArrayList();
        ls = departmentService.findAll();
        Map<String,String> map = new HashMap<String,String>();
        for(int i = 0;i<ls.size();i++){
            String value = Integer.toString(ls.get(i).getId());
            map.put("value",value);
            map.put("label",ls.get(i).getDepartment());
            lm.add(map);
            map = new HashMap<String,String>();
        }
         return lm;

    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据岗位查询该岗位下的用户信息",notes = "查询岗位人员信息")
    public List<Map<String,String>> getUser(@RequestParam("department") String  department, @RequestParam("pageNumber")int pagenum){
        Page page = new Page();
        page.setStart((pagenum-1)*page.getCount());
        int total = departmentService.total(department);
        page.caculateLast(total);
        System.out.println(total);
        System.out.println(page);
        List<Map<String,String>> lm = departmentService.getUser(department,page);
        return lm;
    }
    
}
