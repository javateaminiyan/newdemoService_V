package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alert_usersubscription")
public class AlertSubscriptionUser implements Serializable {

    public AlertSubscriptionUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "subscriptionname")
    private String subscriptionname;
    @Column(name = "status")
    private String status;

    public String getUserid() {
        return userid;
    }

    public AlertSubscriptionUser(String userid, String subscriptionname, String status) {
        this.userid = userid;
        this.subscriptionname = subscriptionname;
        this.status = status;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriptionname() {
        return subscriptionname;
    }

    public void setSubscriptionname(String subscriptionname) {
        this.subscriptionname = subscriptionname;
    }
}
