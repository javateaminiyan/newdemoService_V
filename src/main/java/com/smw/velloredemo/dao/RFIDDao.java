package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rfid_log")
public class RFIDDao implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rfidid")
    private Long id;


    @Column(name = "rfidno")
    private String rfidno;

    @Column(name = "userid")
    private String userid;

    @Column(name = "vehicleno")
    private String vehicleno;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfidno() {
        return rfidno;
    }

    public void setRfidno(String rfidno) {
        this.rfidno = rfidno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getVehicleno() {
        return vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.vehicleno = vehicleno;
    }

    public RFIDDao() {
    }

    public RFIDDao(String rfidno, String userid, String vehicleno) {
        this.rfidno = rfidno;
        this.userid = userid;
        this.vehicleno = vehicleno;
    }
}
