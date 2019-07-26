package com.hubu.service;

import com.hubu.entity.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    public void add(Event event);
    public void update(Event event);
    public void delete(int id);
    public List<Event> findByDep(String department);
    public Event getBylog( String department, Date locayday);
}
