package com.AgileSof.Shield.dto;

import java.security.PrivateKey;

public class MissionUpdateDto {


    private  Long id;

    private String missionName;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MissionUpdateDto(Long id, String missionName, String missionStatus) {
        this.id = id;
        this.missionName = missionName;
        this.missionStatus = missionStatus;
    }

    public MissionUpdateDto() {
    }

    @Override
    public String
    toString() {
        return "MissionUpdateDto{" +
                "id=" + id +
                ", missionName='" + missionName + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                '}';
    }
}