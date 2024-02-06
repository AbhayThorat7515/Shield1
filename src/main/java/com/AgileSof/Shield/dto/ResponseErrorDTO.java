package com.AgileSof.Shield.dto;

public class ResponseErrorDTO {


    private String fieldName;
    private String errorMessage;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseErrorDTO(String fieldName, String errorMessage) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    public ResponseErrorDTO() {
    }

    @Override
    public String toString() {
        return "ResponseErrorDTO{" +
                "fieldName='" + fieldName + '\'' +
                ", errorMassage='" + errorMessage + '\'' +
                '}';
    }
}
