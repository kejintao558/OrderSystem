package com.hubu.service;

import com.hubu.entity.Log;


import java.util.Date;
import java.util.List;

public interface LogService {
    public void add(Log log);
    //    public void delete(int id);
    public void update(Log log);
    public Log find( String depName, Date localday);
    public List<Log> findLog(String department);
}
