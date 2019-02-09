package com.smw.velloredemo.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alert_subscription")
public class AlertSubscription implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;


    @Column(name = "subscriptionname")
    private String subscriptionname;
    @Column(name = "enable")
    private String enable;

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
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
