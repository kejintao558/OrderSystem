package com.hubu.service.serviceImpl;

import com.hubu.dao.LogDao;
import com.hubu.entity.Log;
import com.hubu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public void add(Log log) {
        logDao.add(log);
    }

    @Override
    public void update(Log log) {
        logDao.update(log);
    }

    @Override
    public Log find(String depName, Date localday) {
        return logDao.find(depName,localday);
    }

    @Override
    public List<Log> findLog(String department) {
        return logDao.findLog(department);
    }
}
