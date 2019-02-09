package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "compliantdropdown")
public class CompliantTypeDao implements Serializable {

    public CompliantTypeDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Column(name = "compianttype")
    private String compianttype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompianttype() {
        return compianttype;
    }

    public void setCompianttype(String compianttype) {
        this.compianttype = compianttype;
    }

    public CompliantTypeDao(String compianttype) {
        this.compianttype = compianttype;
    }
}
