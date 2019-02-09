package com.smw.velloredemo.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehiclemaster")
public class VehicleMasterDao implements Serializable {

    public VehicleMasterDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleno")
    private Long id;

    @Column(name = "vehiclename")
    private String vehiclename;

    @Column(name = "vehicleinformation")
    private String vehicleinformation;
    @Column(name = "vehiclewetquantity")
    private String vehiclewetquantity;
    @Column(name = "vehicledryquantity")
    private String vehicledryquantity;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "categoryId")
    private String categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehiclename() {
        return vehiclename;
    }

    public void setVehiclename(String vehiclename) {
        this.vehiclename = vehiclename;
    }

    public String getVehicleinformation() {
        return vehicleinformation;
    }

    public void setVehicleinformation(String vehicleinformation) {
        this.vehicleinformation = vehicleinformation;
    }

    public String getVehiclewetquantity() {
        return vehiclewetquantity;
    }

    public void setVehiclewetquantity(String vehiclewetquantity) {
        this.vehiclewetquantity = vehiclewetquantity;
    }

    public String getVehicledryquantity() {
        return vehicledryquantity;
    }

    public void setVehicledryquantity(String vehicledryquantity) {
        this.vehicledryquantity = vehicledryquantity;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public VehicleMasterDao(String vehiclename, String vehicleinformation, String vehiclewetquantity, String vehicledryquantity, String capacity, String categoryId) {
        this.vehiclename = vehiclename;
        this.vehicleinformation = vehicleinformation;
        this.vehiclewetquantity = vehiclewetquantity;
        this.vehicledryquantity = vehicledryquantity;
        this.capacity = capacity;
        this.categoryId = categoryId;
    }
}
