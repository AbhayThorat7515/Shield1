package com.AgileSof.Shield.dto;


import javax.validation.constraints.NotBlank;

public class AvengerDto {

    @NotBlank(message = "avengerName is mandatory")
    private String avengerName;

    @NotBlank(message = "avengerStatus is mandatory")
    private String avengerStatus;

    @NotBlank(message =" avengeraNotifucation is mandatory" )
    private String avengerNotification;

    private String emailId;

    private String phoneNumber;

    public AvengerDto() {
    }

    public AvengerDto(String avengerName, String avengerStatus, String avengerNotification, String emailId, String phoneNumber) {
        this.avengerName = avengerName;
        this.avengerStatus = avengerStatus;
        this.avengerNotification = avengerNotification;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getAvengerName() {
        return avengerName;
    }

    public void setAvengerName(String avengerName) {
        this.avengerName = avengerName;
    }

    public String getAvengerStatus() {
        return avengerStatus;
    }

    public void setAvengerStatus(String avengerStatus) {
        this.avengerStatus = avengerStatus;
    }

    public String getAvengerNotification() {
        return avengerNotification;
    }

    public void setAvengerNotification(String avengerNotification) {
        this.avengerNotification = avengerNotification;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AvengerDto{" +
                "avengerName='" + avengerName + '\'' +
                ", avengerStatus='" + avengerStatus + '\'' +
                ", avengerNotification='" + avengerNotification + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
