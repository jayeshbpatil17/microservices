package com.patil.entity;

public class Brand {

    private String brand_name;

    private int year;

    private String country;

    public Brand() {
    }

    public Brand(String brand_name, int year, String country) {
        this.brand_name = brand_name;
        this.year = year;
        this.country = country;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
