package com.smw.velloredemo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.io.Serializable;

public class NotificationRequest implements Serializable {


    public String to ;
    @JsonProperty("notification")
    public NotificationRequestData notification ;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public NotificationRequestData getNotification() {
        return notification;
    }

    public void setNotification(NotificationRequestData notification) {
        this.notification = notification;
    }

    public NotificationRequest(String to, NotificationRequestData notification) {
        this.to = to;
        this.notification = notification;
    }
}
