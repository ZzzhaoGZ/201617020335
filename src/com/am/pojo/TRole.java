package com.am.pojo;

import java.util.Date;

public class TRole {
    private Integer roleid;

    private String rolename;

    private Date rolecreate;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Date getRolecreate() {
        return rolecreate;
    }

    public void setRolecreate(Date rolecreate) {
        this.rolecreate = rolecreate;
    }
}