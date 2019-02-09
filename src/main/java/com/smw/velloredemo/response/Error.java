package com.smw.velloredemo.response;

import org.springframework.http.HttpStatus;

public class Error {

    private HttpStatus status;
    private String response;

    public Error() {
    }


    public Error(HttpStatus status, String response) {
        this.status = status;
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}