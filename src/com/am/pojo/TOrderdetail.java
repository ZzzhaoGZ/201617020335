package com.am.pojo;

import java.math.BigDecimal;

public class TOrderdetail {
    private Integer orderdetailid;

    private String ordernum;

    private Integer itemid;

    private Integer itemnum;

    private BigDecimal ordercurrency;

    private BigDecimal orderweight;

    public Integer getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(Integer orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemnum() {
        return itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }

    public BigDecimal getOrdercurrency() {
        return ordercurrency;
    }

    public void setOrdercurrency(BigDecimal ordercurrency) {
        this.ordercurrency = ordercurrency;
    }

    public BigDecimal getOrderweight() {
        return orderweight;
    }

    public void setOrderweight(BigDecimal orderweight) {
        this.orderweight = orderweight;
    }
}