package com.hubu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import sun.font.TrueTypeFont;

import java.util.Date;

public class Log {
    private int id;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd")
    private Date localday;
    private String department;
    private String hander;
    private String carryer;
    private String remark;
    private Boolean handflag = Boolean.FALSE;
    private Boolean carryflag = Boolean.FALSE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLocalday() {
        return localday;
    }

    public void setLocalday(Date localday) {
        this.localday = localday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHander() {
        return hander;
    }

    public void setHander(String hander) {
        this.hander = hander;
    }

    public String getCarryer() {
        return carryer;
    }

    public void setCarryer(String carryer) {
        this.carryer = carryer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getHandflag() {
        return handflag;
    }

    public void setHandflag(Boolean handflag) {
        this.handflag = handflag;
    }

    public Boolean getCarryflag() {
        return carryflag;
    }

    public void setCarryflag(Boolean carryflag) {
        this.carryflag = carryflag;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", localday=" + localday +
                ", department='" + department + '\'' +
                ", hander='" + hander + '\'' +
                ", carryer='" + carryer + '\'' +
                ", remark='" + remark + '\'' +
                ", handflag=" + handflag +
                ", carryflag=" + carryflag +
                '}';
    }
}
