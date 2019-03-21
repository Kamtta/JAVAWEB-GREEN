package com.neuedu.bean;

import java.util.Date;

public class User {
    private Integer uid;
    private String uname;
    private String upwd;
    private Integer usex;
    private Date ubirthday;
    private String receiver;
    private String raddress;
    private String rtelephone;
    private Integer rlevel;
    private String raids;
    private Integer ifdelete;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRtelephone() {
        return rtelephone;
    }

    public void setRtelephone(String rtelephone) {
        this.rtelephone = rtelephone;
    }

    public Integer getRlevel() {
        return rlevel;
    }

    public void setRlevel(Integer rlevel) {
        this.rlevel = rlevel;
    }

    public String getRaids() {
        return raids;
    }

    public void setRaids(String raids) {
        this.raids = raids;
    }

    public Integer getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex=" + usex +
                ", ubirthday=" + ubirthday +
                ", receiver='" + receiver + '\'' +
                ", raddress='" + raddress + '\'' +
                ", rtelephone='" + rtelephone + '\'' +
                ", rlevel=" + rlevel +
                ", raids='" + raids + '\'' +
                ", ifdelete=" + ifdelete +
                '}';
    }
}
