package com.patila.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Citizen{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String gender;

    @JsonManagedReference
    @OneToOne(mappedBy = "citizen",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Aadhar aadhar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    public Citizen(Long id, String name, String gender, Aadhar aadhar) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.aadhar = aadhar;
    }

    public Citizen() {
    }
}
