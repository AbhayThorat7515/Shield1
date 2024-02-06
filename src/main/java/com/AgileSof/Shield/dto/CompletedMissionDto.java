package com.AgileSof.Shield.dto;

import java.util.List;

public class CompletedMissionDto {

    private String avengerName;
    private String emailId;
    private String phoneNumber;
    private List<MissionDto> missionDtoList;

    public String getAvengerName() {
        return avengerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<MissionDto> getMissionDtoList() {
        return missionDtoList;
    }

    public static void setPhone(String phoneNumber) {
    }

    public static void setEmailId(String emailId) {
    }

    public static void setAvenger(String avengerName) {
    }

    public void setMissionDtoList(List<MissionDto> missionDtoList) {
    }

    public CompletedMissionDto(String avengerName, String emailId, String phoneNumber, List<MissionDto> missionDtoList) {
        this.avengerName = avengerName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.missionDtoList = missionDtoList;
    }

    public CompletedMissionDto() {
    }

    @Override
    public String toString() {
        return "CompletedMissionDto{" +
                "avengerName='" + avengerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", missionDtoList=" + missionDtoList +
                '}';
    }
}