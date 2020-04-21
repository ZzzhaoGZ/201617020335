package com.am.pojo;

import java.util.Date;

public class TRoute {
    private Integer routeid;

    private String routename;

    private String routedesc;

    private Date routecreate;

    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }

    public String getRoutename() {
        return routename;
    }

    public void setRoutename(String routename) {
        this.routename = routename == null ? null : routename.trim();
    }

    public String getRoutedesc() {
        return routedesc;
    }

    public void setRoutedesc(String routedesc) {
        this.routedesc = routedesc == null ? null : routedesc.trim();
    }

    public Date getRoutecreate() {
        return routecreate;
    }

    public void setRoutecreate(Date routecreate) {
        this.routecreate = routecreate;
    }
}