package com.hubu.dao;

import com.hubu.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LogDao {
    public void add(Log log);
//    public void delete(int id);
    public void update(Log log);
    public Log find(@Param("department") String depName, @Param("localday")Date localday);
    public List<Log> findLog(String department);
}
