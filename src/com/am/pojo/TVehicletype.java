package com.am.pojo;

import java.util.Date;

public class TVehicletype {
    private Integer typeid;

    private String typename;

    private Date typecreate;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Date getTypecreate() {
        return typecreate;
    }

    public void setTypecreate(Date typecreate) {
        this.typecreate = typecreate;
    }
}