package com.smw.velloredemo.Pojo;

import com.smw.velloredemo.dao.WardDao;

import java.util.List;

public class IndividualWardReportPojo {
    public IndividualWardReportPojo(List<WardDao> ward, List<reportpojo> wardReport) {
        this.ward = ward;
        this.wardReport = wardReport;
    }

    public IndividualWardReportPojo() {
    }


    private List<WardDao> ward;

    private List<reportpojo> wardReport;

    public List<WardDao> getWard() {
        return ward;
    }

    public void setWard(List<WardDao> ward) {
        this.ward = ward;
    }

    public List<reportpojo> getWardReport() {
        return wardReport;
    }

    public void setWardReport(List<reportpojo> wardReport) {
        this.wardReport = wardReport;
    }
}
