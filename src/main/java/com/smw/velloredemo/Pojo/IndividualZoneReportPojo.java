package com.smw.velloredemo.Pojo;

import com.smw.velloredemo.dao.ZoneDao;

import java.io.Serializable;
import java.util.List;

public class IndividualZoneReportPojo implements Serializable {



    private List<ZoneDao> Zone;

    private List<reportpojo> ZoneReport;

    public IndividualZoneReportPojo() {
    }

    public List<ZoneDao> getZone() {
        return Zone;
    }

    public void setZone(List<ZoneDao> zone) {
        Zone = zone;
    }

    public List<reportpojo> getZoneReport() {
        return ZoneReport;
    }

    public void setZoneReport(List<reportpojo> zoneReport) {
        ZoneReport = zoneReport;
    }

    public IndividualZoneReportPojo(List<ZoneDao> zone, List<reportpojo> zoneReport) {
        Zone = zone;
        ZoneReport = zoneReport;
    }
}
