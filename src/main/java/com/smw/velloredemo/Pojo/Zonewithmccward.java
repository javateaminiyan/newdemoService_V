package com.smw.velloredemo.Pojo;

public class Zonewithmccward {

    public Zonewithmccward() {
    }

    private int[] zoneidarray;
    private int[] mccidarray;

    private int[] wardidarray;
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

    public int[] getWardidarray() {
        return wardidarray;
    }

    public void setWardidarray(int[] wardidarray) {
        this.wardidarray = wardidarray;
    }

    public Zonewithmccward(int[] zoneidarray, int[] mccidarray, int[] wardidarray) {
        this.zoneidarray = zoneidarray;
        this.mccidarray = mccidarray;
        this.wardidarray = wardidarray;
    }

}
