package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicleCategoryMaster")
public class CategoryVehicleDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryid")
    private Long id;
    @Column(name = "categoryname")
    private String categoryname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public CategoryVehicleDao() {
    }


}
