package com.example.testspring.models;

public class ResponseError {
    public String message;
    public int errorCode;

    public ResponseError(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
