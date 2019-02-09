package com.smw.velloredemo.response;

import com.smw.velloredemo.dao.RFIDDao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RfidResult implements Serializable {

    Optional<RFIDDao> rfiddetails;
    Object userdetails;

    Object vehicledetails;

    public Optional<RFIDDao> getRfiddetails() {
        return rfiddetails;
    }

    public void setRfiddetails(Optional<RFIDDao> rfiddetails) {
        this.rfiddetails = rfiddetails;
    }

    public Object getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Object userdetails) {
        this.userdetails = userdetails;
    }

    public Object getVehicledetails() {
        return vehicledetails;
    }

    public void setVehicledetails(Object vehicledetails) {
        this.vehicledetails = vehicledetails;
    }

    public RfidResult(Optional<RFIDDao> rfiddetails, Object userdetails, Object vehicledetails) {
        this.rfiddetails = rfiddetails;
        this.userdetails = userdetails;
        this.vehicledetails = vehicledetails;
    }
}
