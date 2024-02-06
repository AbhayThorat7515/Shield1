package com.AgileSof.Shield.exception;

import com.AgileSof.Shield.dto.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;

public class ShieldException extends RuntimeException{

    private int code;

    private List<ResponseErrorDTO> responseErrorDtoList;

    private String message;

    private String message2;

    private BindingResult bindingResult;


    public ShieldException(HttpStatus code, String message){
        this.code=code.value();
        this.message=message;
    }

    public ShieldException(BindingResult bindingResult,HttpStatus code, String message) {
        this.bindingResult=bindingResult;
        this.code=code.value();
        this.message=message;

    }

    public ShieldException(HttpStatus code, List<ResponseErrorDTO> responseErrorDTOList, String massage) {
        this.code = code.value();
        this.responseErrorDtoList = responseErrorDTOList;
        this.message = massage;
    }

    public ShieldException(int code, List<ResponseErrorDTO> responseErrorDtoList, String message) {
        this.code = code;
        this.responseErrorDtoList = responseErrorDtoList;
        this.message = message;
    }

    public ShieldException(String message, Throwable cause, int code, List<ResponseErrorDTO> responseErrorDtoList, String message1) {
        super(message, cause);
        this.code = code;
        this.responseErrorDtoList = responseErrorDtoList;
        this.message = message1;
    }

    public ShieldException(Throwable cause, int code, List<ResponseErrorDTO> responseErrorDtoList, String message) {
        super(cause);
        this.code = code;
        this.responseErrorDtoList = responseErrorDtoList;
        this.message = message;
    }

    public ShieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, List<ResponseErrorDTO> responseErrorDtoList, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.responseErrorDtoList = responseErrorDtoList;
        this.message = message1;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResponseErrorDTO> getResponseErrorDtoList() {
        return responseErrorDtoList;
    }

    public void setResponseErrorDtoList(List<ResponseErrorDTO> responseErrorDtoList) {
        this.responseErrorDtoList = responseErrorDtoList;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ShieldException() {
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    @Override
    public String toString() {
        return "ShieldException{" +
                "code=" + code +
                ", responseErrorDtoList=" + responseErrorDtoList +
                ", message='" + message + '\'' +
                ", message2='" + message2 + '\'' +
                ", bindingResult=" + bindingResult +
                '}';
    }
}
