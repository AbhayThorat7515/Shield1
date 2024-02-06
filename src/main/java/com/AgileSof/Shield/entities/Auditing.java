package com.AgileSof.Shield.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Auditing extends BaseEntity{

    @CreationTimestamp
    @Column(name = "created_at",unique = false)
    private Date created_at=new Date();

    @UpdateTimestamp
    @Column(name = "updated_at", unique = false)
    private Date update_at=new Date();

    public Auditing() {
    }

    public Auditing(Date created_at, Date update_at) {
        super();
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
