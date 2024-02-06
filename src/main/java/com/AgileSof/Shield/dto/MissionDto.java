package com.AgileSof.Shield.dto;


import javax.validation.constraints.NotBlank;

public class MissionDto {

    @NotBlank(message = "missionName is mandatory")
    private String missionName;

    @NotBlank(message = "missionStatus is mandatory")
    private String missionStatus;

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

    public MissionDto(String missionName, String missionStatus) {
        this.missionName = missionName;
        this.missionStatus = missionStatus;
    }


    public MissionDto() {
    }

    @Override
    public String toString() {
        return "MissionDto{" +
                "missionName='" + missionName + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                '}';
    }
}
