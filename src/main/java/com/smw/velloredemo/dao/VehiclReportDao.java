package com.smw.velloredemo.dao;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vehiclereport")
public class VehiclReportDao implements Serializable {


    public VehiclReportDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleid")
    private Long vehicleid;


    @Column(name = "vehiclename")
    private String vehiclename;


    @Column(name = "vehiclecapacity")
    private String vehiclecapacity;

    @Column(name = "vehicleinformation")
    private String vehicleinformation;

    @Column(name = "userid")
    private String userid;

    @Column(name = "mobileno")
    private String mobileno;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "intime")
    private Date intime;








    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "outtime")
    private Date outtime;


    @Column(name = "zoneid")
    private String zoneid;

    @Column(name = "mccid")
    private String mccid;

    @Column(name = "wardid")
    private String wardid;

    public String getZoneid() {
        return zoneid;
    }

    public void setZoneid(String zoneid) {
        this.zoneid = zoneid;
    }

    public String getMccid() {
        return mccid;
    }

    public void setMccid(String mccid) {
        this.mccid = mccid;
    }

    public String getWardid() {
        return wardid;
    }

    public void setWardid(String wardid) {
        this.wardid = wardid;
    }

    public String getEntrytype() {
        return entrytype;
    }

    public void setEntrytype(String entrytype) {
        this.entrytype = entrytype;
    }

    @Column(name = "entrytype")
    private String entrytype;



//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_date")
//    private Date createDate;
//
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "modify_date")
//    private Date modifyDate;


    @Column(name = "updateby")
    private String updateby;

    @Column(name = "rfid")
    private String rfid;
    @Column(name = "totalquantity")
    private String totalquantity;


    @Column(name = "wet")
    private String wet;

    @Column(name = "vehicleno")
    private String vehicleno;





    @Column(name = "dry")
    private String dry;

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public VehiclReportDao(String vehiclename, String vehiclecapacity, String vehicleinformation, String userid, String mobileno, Date intime, Date outtime, String updateby, String rfid, String totalquantity, String wet, String vehicleno, String dry) {
        this.vehiclename = vehiclename;
        this.vehiclecapacity = vehiclecapacity;
        this.vehicleinformation = vehicleinformation;
        this.userid = userid;
        this.mobileno = mobileno;
        this.intime = intime;
        this.outtime = outtime;
        this.updateby = updateby;
        this.rfid = rfid;
        this.totalquantity = totalquantity;
        this.wet = wet;
        this.vehicleno = vehicleno;
        this.dry = dry;
    }

    public Long getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(Long vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }

    public String getVehiclecapacity() {
        return vehiclecapacity;
    }

    public void setVehiclecapacity(String vehiclecapacity) {
        this.vehiclecapacity = vehiclecapacity;
    }

    public String getVehicleinformation() {
        return vehicleinformation;
    }

    public void setVehicleinformation(String vehicleinformation) {
        this.vehicleinformation = vehicleinformation;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getTotalquantity() {
        return totalquantity;
    }

    public void setTotalquantity(String totalquantity) {
        this.totalquantity = totalquantity;
    }

    public String getWet() {
        return wet;
    }

    public void setWet(String wet) {
        this.wet = wet;
    }

    public String getDry() {
        return dry;
    }

    public void setDry(String dry) {
        this.dry = dry;
    }
}


