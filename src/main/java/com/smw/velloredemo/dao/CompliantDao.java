package com.smw.velloredemo.dao;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliant")
public class CompliantDao implements Serializable {
    public CompliantDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "userid")
    private String userid;
    @Column(name = "complianttype")
    private String complianttype;
    @Column(name = "priority")
    private String priority;

    @Column(name = "wardno")
    private String wardno;

    @Column(name = "district")
    private String district;

    @Column(name = "status")
    private String status;

    //    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//@CreationTimestamp
    @CreationTimestamp
    @Column(name = "createdby")
    private LocalDateTime createdby;

    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedby")
    private LocalDateTime updatedby;

    @DefaultValue(value = "iniyan")
    @Column(name = "assignedby")
    private String assignedby;

    @Column(name = "adminmessage")
    private String adminmessage="Pending";

    @Column(name = "statusissues")
    private String statusissues="No";


//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_date")
//    private Date createDate;

    public LocalDateTime getCreatedby() {
        return createdby;
    }

    public void setCreatedby(LocalDateTime createdby) {
        this.createdby = createdby;
    }

    public LocalDateTime getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(LocalDateTime updatedby) {
        this.updatedby = updatedby;
    }

    public String getAdminmessage() {
        return adminmessage;
    }

    public void setAdminmessage(String adminmessage) {
        this.adminmessage = adminmessage;
    }

    public String getStatusissues() {
        return statusissues;
    }

    public void setStatusissues(String statusissues) {
        this.statusissues = statusissues;
    }

//
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "modify_date")
//    private Date modifyDate;

    @NotBlank
    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getComplianttype() {
        return complianttype;
    }

    public void setComplianttype(String complianttype) {
        this.complianttype = complianttype;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWardno() {
        return wardno;
    }

    public void setWardno(String wardno) {
        this.wardno = wardno;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedby() {
        return assignedby;
    }

    public void setAssignedby(String assignedby) {
        this.assignedby = assignedby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
