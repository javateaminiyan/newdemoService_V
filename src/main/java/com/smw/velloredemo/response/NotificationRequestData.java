package com.smw.velloredemo.response;

import org.json.JSONObject;

public class NotificationRequestData {


    public String body ;
    public String title ;
    public JSONObject jsonobject ;

    public NotificationRequestData(String body, String title, JSONObject jsonobject) {
        this.body = body;
        this.title = title;
        this.jsonobject = jsonobject;
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

    public JSONObject getJsonobject() {
        return jsonobject;
    }

    public void setJsonobject(JSONObject jsonobject) {
        this.jsonobject = jsonobject;
    }
}
