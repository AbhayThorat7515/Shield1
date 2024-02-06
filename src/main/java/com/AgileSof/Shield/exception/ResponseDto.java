package com.AgileSof.Shield.exception;

import java.util.Optional;

public class ResponseDto<T> {

    private int code;
    private String message;
    private T body;

    public ResponseDto() {
    }

    public ResponseDto(int code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public <addAvenger> ResponseDto(int value, String avangerAddSuccessfully, int addAvenger) {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
