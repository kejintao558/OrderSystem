package com.hubu.service.serviceImpl;

import com.hubu.dao.DepartmentDao;
import com.hubu.entity.Department;
import com.hubu.entity.Page;
import com.hubu.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    //添加岗位
    @Override
    public void add(Department dep) {
        departmentDao.add(dep);

    }

    //删除岗位
    @Override
    public void delete(int id) {
        departmentDao.delete(id);
    }

    //更改岗位
    @Override
    public void update(Department dep) {
        dep.setDepartment(dep.getDepartment());
        departmentDao.update(dep);
    }

    //根据id查询岗位
    @Override
    public Department find(int id) {
        return departmentDao.find(id);
    }

    //查询所有岗位类
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    //查询所有岗位，返回岗位列表
    @Override
    public List<String> getDep() {
        return departmentDao.getDep();
    }

    //根据岗位查询该岗位下的用户信息，用于分页
    @Override
    public List<Map<String,String>> getUser(String department, Page page) {
        return departmentDao.getUser(department,page);

    }

    //统计该岗位下的用户人数
    @Override
    public int total(String department) {
        return departmentDao.total(department);
    }

    @Override
    public int getId(String department) {
        return departmentDao.getId(department);
    }

    @Override
    public String findDep(int id) {
        return departmentDao.findDep(id);
    }
}
