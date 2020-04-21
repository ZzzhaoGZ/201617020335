package com.am.pojo;

import java.math.BigDecimal;

public class TVehicle {
    private Integer vehicleid;

    private String vehicleowername;

    private String vehiclenum;

    private String vehicleowercontact;

    private String vehicleowerid;

    private String vehicledrivername;

    private String vehicledriverid;

    private Integer vehicletypeid;

    private BigDecimal vehicleload;

    private String vehiclestatus;

    public Integer getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Integer vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehicleowername() {
        return vehicleowername;
    }

    public void setVehicleowername(String vehicleowername) {
        this.vehicleowername = vehicleowername == null ? null : vehicleowername.trim();
    }

    public String getVehiclenum() {
        return vehiclenum;
    }

    public void setVehiclenum(String vehiclenum) {
        this.vehiclenum = vehiclenum == null ? null : vehiclenum.trim();
    }

    public String getVehicleowercontact() {
        return vehicleowercontact;
    }

    public void setVehicleowercontact(String vehicleowercontact) {
        this.vehicleowercontact = vehicleowercontact == null ? null : vehicleowercontact.trim();
    }

    public String getVehicleowerid() {
        return vehicleowerid;
    }

    public void setVehicleowerid(String vehicleowerid) {
        this.vehicleowerid = vehicleowerid == null ? null : vehicleowerid.trim();
    }

    public String getVehicledrivername() {
        return vehicledrivername;
    }

    public void setVehicledrivername(String vehicledrivername) {
        this.vehicledrivername = vehicledrivername == null ? null : vehicledrivername.trim();
    }

    public String getVehicledriverid() {
        return vehicledriverid;
    }

    public void setVehicledriverid(String vehicledriverid) {
        this.vehicledriverid = vehicledriverid == null ? null : vehicledriverid.trim();
    }

    public Integer getVehicletypeid() {
        return vehicletypeid;
    }

    public void setVehicletypeid(Integer vehicletypeid) {
        this.vehicletypeid = vehicletypeid;
    }

    public BigDecimal getVehicleload() {
        return vehicleload;
    }

    public void setVehicleload(BigDecimal vehicleload) {
        this.vehicleload = vehicleload;
    }

    public String getVehiclestatus() {
        return vehiclestatus;
    }

    public void setVehiclestatus(String vehiclestatus) {
        this.vehiclestatus = vehiclestatus == null ? null : vehiclestatus.trim();
    }
}