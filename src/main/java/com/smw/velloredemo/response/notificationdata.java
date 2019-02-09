package com.smw.velloredemo.response;

import java.time.LocalDateTime;
import java.util.Date;
import org.json.JSONObject;

public class notificationdata {
    private  String to,body,title;

    private   JSONObject jsonObject;
    private LocalDateTime date;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public notificationdata(String to, String body, String title, JSONObject jsonObject, LocalDateTime date) {
        this.to = to;
        this.body = body;
        this.title = title;
        this.jsonObject = jsonObject;
        this.date = date;
    }
}
