package com.hubu.service.serviceImpl;

import com.hubu.dao.EventDao;
import com.hubu.entity.Event;
import com.hubu.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDao eventDao;

    @Override
    public void add(Event event) {
        eventDao.add(event);
    }

    @Override
    public List<Event> findByDep(String department) {
        return eventDao.findByDep(department);
    }

    @Override
    public void update(Event event) {
        eventDao.update(event);
    }

    @Override
    public void delete(int id) {
        eventDao.delete(id);
    }

    @Override
    public Event getBylog(String department, Date locayday) {
        return eventDao.getBylog(department,locayday);
    }
}
