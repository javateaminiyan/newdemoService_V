package com.smw.velloredemo.Pojo;


import javax.persistence.*;

@Entity
@Table(name = "mcc")
public class MccDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmcc;


    private String mccname;

    private String controlby;
    private String zoneid;

    public MccDao() {
    }

    public Integer getIdmcc() {
        return idmcc;
    }

    public void setIdmcc(Integer idmcc) {
        this.idmcc = idmcc;
    }

    public String getMccname() {
        return mccname;
    }

    public void setMccname(String mccname) {
        this.mccname = mccname;
    }

    public String getControlby() {
        return controlby;
    }

    public void setControlby(String controlby) {
        this.controlby = controlby;
    }

    public String getZoneid() {
        return zoneid;
    }

    public void setZoneid(String zoneid) {
        this.zoneid = zoneid;
    }
}
