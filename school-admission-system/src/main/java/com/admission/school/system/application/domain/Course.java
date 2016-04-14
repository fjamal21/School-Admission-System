package com.admission.school.system.application.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 9093107641116011157L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "fee")
    private Integer fee;

    @Column(name = "admission_open_on")
    private Timestamp admissionOpenOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Timestamp getAdmissionOpenOn() {
        return admissionOpenOn;
    }

    public void setAdmissionOpenOn(Timestamp admissionOpenOn) {
        this.admissionOpenOn = admissionOpenOn;
    }
}
