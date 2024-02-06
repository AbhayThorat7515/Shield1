package com.AgileSof.Shield.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "avenger")
public class Avenger extends Auditing {

    @Column(name = "avenger_name", nullable = false)
    private String avengerName;

    @Column(name = "avenger_status", nullable = false)
    private String avengerStatus;

    @Column(name ="avenger_notification", nullable = false)
    private String avengerNotification;

    @Column(name ="email_id", nullable = false)
    private String emailId;

    @Column(name ="phone_number", nullable = false)
        private String phoneNumber;


    public Avenger() {
    }
    public Avenger(String avengerName, String avengerStatus, String avengerNotification, String emailId, String phoneNumber) {
        this.avengerName = avengerName;
        this.avengerStatus = avengerStatus;
        this.avengerNotification = avengerNotification;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public Avenger(Date created_at, Date update_at, String avengerName, String avengerStatus, String avengerNotification, String emailId, String phoneNumber) {
        super(created_at, update_at);
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
        return "Avenger{" +
                "avengerName='" + avengerName + '\'' +
                ", avengerStatus='" + avengerStatus + '\'' +
                ", avengerNotification='" + avengerNotification + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
