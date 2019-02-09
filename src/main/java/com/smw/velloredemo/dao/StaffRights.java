package com.smw.velloredemo.dao;


import javax.persistence.*;

@Entity
@Table(name = "staffrights")
public class StaffRights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String userid;

    private  String roleid;

    private  String zoneid;

    private  String wardid;

    private  String mccid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getZoneid() {
        return zoneid;
    }

    public void setZoneid(String zoneid) {
        this.zoneid = zoneid;
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        this.wardid = wardid;
    }

    public String getMccid() {
        return mccid;
    }

    public void setMccid(String mccid) {
        this.mccid = mccid;
    }

    public StaffRights() {
    }
}
