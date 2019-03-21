package com.neuedu.bean;

import java.util.Date;

public class Order {
    private Integer oid;
    private String oNum;
    private String gphoto;
    private Integer uid;
    private Integer gid;
    private Integer gnum;
    private Date ocreatedate;
    private Integer ifupload;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
    }

    public String getGphoto() {
        return gphoto;
    }

    public void setGphoto(String gphoto) {
        this.gphoto = gphoto;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Date getOcreatedate() {
        return ocreatedate;
    }

    public void setOcreatedate(Date ocreatedate) {
        this.ocreatedate = ocreatedate;
    }

    public Integer getIfupload() {
        return ifupload;
    }

    public void setIfupload(Integer ifupload) {
        this.ifupload = ifupload;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oNum='" + oNum + '\'' +
                ", gphoto='" + gphoto + '\'' +
                ", uid=" + uid +
                ", gid=" + gid +
                ", gnum=" + gnum +
                ", ocreatedate=" + ocreatedate +
                ", ifupload=" + ifupload +
                '}';
    }
}
