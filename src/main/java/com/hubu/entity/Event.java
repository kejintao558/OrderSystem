package com.hubu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    private int id;
    private String title;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd")
    private Date start;
    private Boolean allday = Boolean.TRUE ;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Boolean getAllday() {
        return allday;
    }

    public void setAllday(Boolean allday) {
        this.allday = allday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", start=" + start +
                ", allday=" + allday +
                ", department='" + department + '\'' +
                '}';
    }
}
