package com.AgileSof.Shield.entities;


import javax.persistence.*;

@Entity
@Table(name = "mission")
public class Mission extends Auditing {


    @Column(name = "mission_name",nullable = false)
    private String missionName;

    @Column(name = "mission_status",nullable = false)
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

    public Mission() {
    }

    public Mission(String missionName, String missionStatus) {
        this.missionName = missionName;
        this.missionStatus = missionStatus;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "missionName='" + missionName + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                '}';
    }
}
