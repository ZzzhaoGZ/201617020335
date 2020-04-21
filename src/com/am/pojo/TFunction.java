package com.am.pojo;

public class TFunction {
    private Integer functionid;

    private Integer functionparentid;

    private String functionname;

    private String functionurl;

    private Boolean functionisparent;

    public Integer getFunctionid() {
        return functionid;
    }

    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    public Integer getFunctionparentid() {
        return functionparentid;
    }

    public void setFunctionparentid(Integer functionparentid) {
        this.functionparentid = functionparentid;
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname == null ? null : functionname.trim();
    }

    public String getFunctionurl() {
        return functionurl;
    }

    public void setFunctionurl(String functionurl) {
        this.functionurl = functionurl == null ? null : functionurl.trim();
    }

    public Boolean getFunctionisparent() {
        return functionisparent;
    }

    public void setFunctionisparent(Boolean functionisparent) {
        this.functionisparent = functionisparent;
    }
}