package com.hubu.service;

import com.hubu.entity.Department;
import com.hubu.entity.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    void add(Department dep);
    void delete(int id);
    void update(Department dep);
    Department find(int id);
    List<Department> findAll();
    List<String> getDep();
    List<Map<String,String>> getUser(String department, Page page);
    int total(String depatmenrt);
    int getId(String department);
    String findDep(int id);

}
