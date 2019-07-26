package com.hubu.dao;

import com.hubu.entity.Event;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EventDao {
    public void add(Event event);
    public void update(Event event);
    public void delete(int id);
    public List<Event> findByDep(String department);
    public Event getBylog(@Param("department") String department, @Param("localday")Date locayday);
}
