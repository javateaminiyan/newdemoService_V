package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "proritytype")
public class CompliantPriorityTypeDao implements Serializable {
    public CompliantPriorityTypeDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Long id;


    @Column(name = "proritytype")
    private  String proritytype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProritytype() {
        return proritytype;
    }

    public void setProritytype(String proritytype) {
        this.proritytype = proritytype;
    }
}
