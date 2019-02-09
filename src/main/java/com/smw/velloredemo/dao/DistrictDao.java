package com.smw.velloredemo.dao;


import javax.persistence.*;

@Entity
@Table(name="district")
public class DistrictDao {

    public DistrictDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long districtid;

    public String districtname;

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public DistrictDao(String districtname) {
        this.districtname = districtname;
    }


}
