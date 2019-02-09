package com.smw.velloredemo.Pojo;

public class reportpojo {

    public reportpojo() {
    }

   private String wetcount="0", drycount="0", totalcount="0", vehiclecount="0";

    public String getWetcount() {
        return wetcount;
    }

    public reportpojo setWetcount(String wetcount) {
        this.wetcount = wetcount;
        return this;
    }

    public String getDrycount() {
        return drycount;
    }

    public reportpojo setDrycount(String drycount) {
        this.drycount = drycount;
        return this;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public reportpojo setTotalcount(String totalcount) {
        this.totalcount = totalcount;
        return this;
    }

    public String getVehiclecount() {
        return vehiclecount;

    }

    public reportpojo setVehiclecount(String vehiclecount) {
        this.vehiclecount = vehiclecount;
        return this;
    }
}
