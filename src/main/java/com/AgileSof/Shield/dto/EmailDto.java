package com.AgileSof.Shield.dto;

public class EmailDto {

    private String emailId;

    private String phoneNumber;

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

    public EmailDto(String emailId, String phoneNumber) {
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public EmailDto() {
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
