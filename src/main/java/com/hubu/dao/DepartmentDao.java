package com.hubu.dao;

import com.hubu.entity.Department;
import com.hubu.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {
    public void add(Department department);
    public void delete(int id);
    public Department find(int id);
    public void update(Department department);
    public List<Map<String,String>> getUser(@Param("department") String depName,@Param("page") Page page);
    public List<Department> findAll();
    public List<String> getDep();
    public int total(String department);
    public int getId(String department);
    public String findDep(int id);
}
