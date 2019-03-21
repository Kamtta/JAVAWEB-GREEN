package com.neuedu.bean;

public class ShoppingCart {
    private Integer sid;
    private String gname;
    private String gphoto;
    private double gprice;
    private Integer num;
    private Integer gifupload;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGphoto() {
        return gphoto;
    }

    public void setGphoto(String gphoto) {
        this.gphoto = gphoto;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public Integer getGifupload() {
        return gifupload;
    }

    public void setGifupload(Integer gifupload) {
        this.gifupload = gifupload;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "sid=" + sid +
                ", gname='" + gname + '\'' +
                ", gphoto='" + gphoto + '\'' +
                ", gprice=" + gprice +
                ", num=" + num +
                ", gifupload=" + gifupload +
                '}';
    }
}
