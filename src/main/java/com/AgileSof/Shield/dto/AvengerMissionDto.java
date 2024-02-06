package com.AgileSof.Shield.dto;


public class AvengerMissionDto {
    private String avengerName;

    private String avengerStatus;

    private String avengerNotification;

    private String emailId;

    private String phoneNumber;

    private String missionName;

    private String missionStatus;

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

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public AvengerMissionDto(String avengerName, String avengerStatus, String avengerNotification, String emailId, String phoneNumber, String missionName, String missionStatus) {
        this.avengerName = avengerName;
        this.avengerStatus = avengerStatus;
        this.avengerNotification = avengerNotification;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.missionName = missionName;
        this.missionStatus = missionStatus;
    }

    public AvengerMissionDto() {
    }

    @Override
    public String toString() {
        return "AvengerMissionDto{" +
                "avengerName='" + avengerName + '\'' +
                ", avengerStatus='" + avengerStatus + '\'' +
                ", avengerNotification='" + avengerNotification + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", missionName='" + missionName + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                '}';
    }
}
