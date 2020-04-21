package com.am.pojo;

import java.util.Date;

public class TSpecies {
    private Integer speciesid;

    private Integer speciesparentid;

    private String speciesname;

    private Date speciestime;

    private Boolean isparent;

    public Integer getSpeciesid() {
        return speciesid;
    }

    public void setSpeciesid(Integer speciesid) {
        this.speciesid = speciesid;
    }

    public Integer getSpeciesparentid() {
        return speciesparentid;
    }

    public void setSpeciesparentid(Integer speciesparentid) {
        this.speciesparentid = speciesparentid;
    }

    public String getSpeciesname() {
        return speciesname;
    }

    public void setSpeciesname(String speciesname) {
        this.speciesname = speciesname == null ? null : speciesname.trim();
    }

    public Date getSpeciestime() {
        return speciestime;
    }

    public void setSpeciestime(Date speciestime) {
        this.speciestime = speciestime;
    }

    public Boolean getIsparent() {
        return isparent;
    }

    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }
}