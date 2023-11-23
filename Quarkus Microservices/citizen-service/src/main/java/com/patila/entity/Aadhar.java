package com.patila.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Aadhar {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        Long aadharNo;

        String company;

        @OneToOne
        @JsonBackReference
        Citizen citizen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(Long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public Aadhar(Long id, Long aadharNo, String company, Citizen citizen) {
        this.id = id;
        this.aadharNo = aadharNo;
        this.company = company;
        this.citizen = citizen;
    }

    public Aadhar() {
    }
}
