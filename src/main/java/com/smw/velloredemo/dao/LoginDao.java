package com.smw.velloredemo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "login")
public class LoginDao implements Serializable {
    public LoginDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", updatable = false, nullable = false)
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "role", columnDefinition = "VARCHAR(255) default 1", nullable = true)
    private String role = "1";

    @Column(name = "mobileno")
    private String mobileno;

    @JsonIgnore
    @Column(name = "status", columnDefinition = "VARCHAR(255) default 'active'", nullable = true)
    private String status = "active";

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "updatedby")
    private String updatedby;

    @Column(name = "username")
    private String username;

    @Column(name = "city")
    private String city;

    @Column(name = "firebaseid")
    private String firebaseid;

    public String getFirebaseid() {
        return firebaseid;
    }

    public void setFirebaseid(String firebaseid) {
        this.firebaseid = firebaseid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

