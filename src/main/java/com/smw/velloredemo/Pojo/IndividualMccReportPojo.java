package com.smw.velloredemo.Pojo;

import com.smw.velloredemo.dao.ZoneDao;

import java.util.List;

public class IndividualMccReportPojo {

    public IndividualMccReportPojo() {
    }

    public List<MccDao> getMcc() {
        return mcc;
    }

    public void setMcc(List<MccDao> mcc) {
        this.mcc = mcc;
    }

    public List<reportpojo> getMccreport() {
        return mccreport;
    }

    public void setMccreport(List<reportpojo> mccreport) {
        this.mccreport = mccreport;
    }

    public IndividualMccReportPojo(List<MccDao> mcc, List<reportpojo> mccreport) {
        this.mcc = mcc;
        this.mccreport = mccreport;
    }

    private List<MccDao> mcc;
    private List<reportpojo> mccreport;

}
