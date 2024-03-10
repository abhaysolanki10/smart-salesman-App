package com.example.freewaresys.smartsalesman;

/**
 * Created by Damini on 13-03-2017.
 */
public class Customerclass {

    public String cid,cityid,areaid,cname,cemail,cmno,cpwd;
    public  byte[] cimage;
  /*  public Customerclass(String cid,String cname,String cemail,String cityid,String areaid,String mno,byte[]cimage)
    {
            this.cid=cid;
            this.cname=cname;
            this.cemail=cemail;
            this.cityid=cityid;
            this.areaid=areaid;
            this.cimage=cimage;
    }*/
    public Customerclass(String cid,String cname,byte[]cimage)
    {
        this.cid=cid;
        this.cname=cname;

        this.cimage=cimage;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCmno() {
        return cmno;
    }

    public void setCmno(String cmno) {
        this.cmno = cmno;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public byte[] getCimage() {
        return cimage;
    }

    public void setCimage(byte[] cimage) {
        this.cimage = cimage;
    }
}
