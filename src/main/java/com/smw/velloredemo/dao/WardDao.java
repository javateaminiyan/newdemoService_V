package com.smw.velloredemo.dao;


import javax.persistence.*;

@Entity
@Table(name = "WardDao")
public class WardDao {
    public WardDao() {
    }

    @Id
    @Column(name = "wardno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long wardno;

    @Column(name = "wardname")
    public String wardname;


    @Column(name = "districtid")
    public Long districtid;
    @Column(name = "zoneid")
    private int zoneid;
    @Column(name = "mccid")
    private int mccid;

    public Long getWardno() {
        return wardno;
    }

    public void setWardno(Long wardno) {
        this.wardno = wardno;
    }

    public String getWardname() {
        return wardname;
    }

    public void setWardname(String wardname) {
        this.wardname = wardname;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getMccid() {
        return mccid;
    }

    public void setMccid(int mccid) {
        this.mccid = mccid;
    }

    public WardDao(Long wardno, String wardname, Long districtid, int zoneid, int mccid) {
        this.wardno = wardno;
        this.wardname = wardname;
        this.districtid = districtid;
        this.zoneid = zoneid;
        this.mccid = mccid;
    }
}
