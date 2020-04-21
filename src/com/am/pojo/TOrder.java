package com.am.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TOrder {
    private Integer orderid;

    private String ordernum;

    private String orderower;

    private String orerowercontact;

    private String orderoweraddress;

    private BigDecimal orderweight;

    private BigDecimal ordercurrency;

    private Date ordercreate;

    private String orderstatus;

    private Integer vehicleid;

    private Integer routeid;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getOrderower() {
        return orderower;
    }

    public void setOrderower(String orderower) {
        this.orderower = orderower == null ? null : orderower.trim();
    }

    public String getOrerowercontact() {
        return orerowercontact;
    }

    public void setOrerowercontact(String orerowercontact) {
        this.orerowercontact = orerowercontact == null ? null : orerowercontact.trim();
    }

    public String getOrderoweraddress() {
        return orderoweraddress;
    }

    public void setOrderoweraddress(String orderoweraddress) {
        this.orderoweraddress = orderoweraddress == null ? null : orderoweraddress.trim();
    }

    public BigDecimal getOrderweight() {
        return orderweight;
    }

    public void setOrderweight(BigDecimal orderweight) {
        this.orderweight = orderweight;
    }

    public BigDecimal getOrdercurrency() {
        return ordercurrency;
    }

    public void setOrdercurrency(BigDecimal ordercurrency) {
        this.ordercurrency = ordercurrency;
    }

    public Date getOrdercreate() {
        return ordercreate;
    }

    public void setOrdercreate(Date ordercreate) {
        this.ordercreate = ordercreate;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public Integer getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Integer vehicleid) {
        this.vehicleid = vehicleid;
    }

    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }
}