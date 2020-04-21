package com.am.pojo;

import java.util.Date;

public class TUser {
    private Integer userid;

    private String userloginid;

    private String userloginpasswd;

    private String usersex;

    private String usercontact;

    private String useremail;

    private Date createtime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserloginid() {
        return userloginid;
    }

    public void setUserloginid(String userloginid) {
        this.userloginid = userloginid == null ? null : userloginid.trim();
    }

    public String getUserloginpasswd() {
        return userloginpasswd;
    }

    public void setUserloginpasswd(String userloginpasswd) {
        this.userloginpasswd = userloginpasswd == null ? null : userloginpasswd.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact == null ? null : usercontact.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}