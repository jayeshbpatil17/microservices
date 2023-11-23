package com.patil.entity;


public class Mobile {

    int id;
    String name;
    String brnad;
    int ram;
    int externalStorage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrnad() {
        return brnad;
    }

    public void setBrnad(String brnad) {
        this.brnad = brnad;
    }

    public int getRam() {
        return ram;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(int externalStorage) {
        this.externalStorage = externalStorage;
    }

    public Mobile() {
    }

    public Mobile(int id,String name, String brnad, int ram, int externalStorage) {
        this.name = name;
        this.brnad = brnad;
        this.ram = ram;
        this.externalStorage = externalStorage;
        this.id = id;
    }
}
