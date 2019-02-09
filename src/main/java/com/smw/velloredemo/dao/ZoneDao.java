package com.smw.velloredemo.dao;


import javax.persistence.*;

@Entity
@Table(name = "zone")
public class ZoneDao {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "zone_id")
    private Long ZoneId;

    public ZoneDao() {
    }

    @Column(name = "zone_name")
    private String ZoneName;


    @Column(name = "district_name")
    private String DistrictName;

    public Long getZoneId() {
        return ZoneId;
    }

    public void setZoneId(Long zoneId) {
        ZoneId = zoneId;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String zoneName) {
        ZoneName = zoneName;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }
}
