package com.smw.velloredemo.Pojo;

public class ZonewithmccPojo {

    private  int[] zoneidarray;
    private  int[] mccidarray;

    public int[] getZoneidarray() {
        return zoneidarray;
    }

    public void setZoneidarray(int[] zoneidarray) {
        this.zoneidarray = zoneidarray;
    }

    public int[] getMccidarray() {
        return mccidarray;
    }

    public void setMccidarray(int[] mccidarray) {
        this.mccidarray = mccidarray;
    }

    public ZonewithmccPojo(int[] zoneidarray, int[] mccidarray) {
        this.zoneidarray = zoneidarray;
        this.mccidarray = mccidarray;
    }
}
