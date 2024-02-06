package com.AgileSof.Shield.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "avengerMission")
public class AvengerMission extends Auditing {

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Mission.class)
    @JoinColumn(name = "mission_id")
    private Mission missions;

    @ManyToOne
    @JoinColumn(name = "avenger_id")
    private Avenger avenger;


    public AvengerMission() {
    }

    public AvengerMission(Mission missions, Avenger avenger) {
        this.missions = missions;
        this.avenger = avenger;
    }

    public AvengerMission(Date created_at, Date update_at, Mission missions, Avenger avenger) {
        super(created_at, update_at);
        this.missions = missions;
        this.avenger = avenger;
    }

    public Mission getMissions() {
        return missions;
    }

    public void setMissions(Mission missions) {
        this.missions = missions;
    }

    public Avenger getAvenger() {
        return avenger;
    }

    public void setAvenger(Avenger avenger) {
        this.avenger = avenger;
    }

    @Override
    public String toString() {
        return "AvengerMission{" +
                "missions=" + missions +
                ", avenger=" + avenger +
                '}';
    }
}
