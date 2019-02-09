package com.smw.velloredemo.Pojo;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable {
    private String username;
    private String password;
    private String role;
    private String mobileno;

    private String firebaseid;

    public String getFirebaseid() {
        return firebaseid;
    }

    public void setFirebaseid(String firebaseid) {
        this.firebaseid = firebaseid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public UserVo(String username, String password, String role, String mobileno, String userid, String city, String firebaseid) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.mobileno = mobileno;
        this.userid = userid;
        this.city = city;

        this.firebaseid = firebaseid;
    }

    private String userid;
    private String city;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
